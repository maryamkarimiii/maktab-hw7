package ir.maktab.hw7.repository;

import ir.maktab.hw7.modle.Doctor;
import ir.maktab.hw7.modle.Patient;
import ir.maktab.hw7.modle.Prescription;
import ir.maktab.hw7.modle.enums.PrescriptionStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionRepository {
    private static PrescriptionRepository prescriptionRepository;

    private PrescriptionRepository() {
    }

    public static PrescriptionRepository getInstance() {
        if (prescriptionRepository == null)
            prescriptionRepository = new PrescriptionRepository();
        return prescriptionRepository;
    }

    public Integer addPrescription(Prescription prescription) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String insertQuery = "INSERT into \"prescription\" (\"date\",user_id,flag) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setDate(1, (Date) prescription.getDate());
        preparedStatement.setString(2, prescription.getPatient().getNationalCode());
        preparedStatement.setBoolean(3, true);
        int result = preparedStatement.executeUpdate();
        int id = 0;
        if (result >= 1) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            id = resultSet.getInt("id");
        }
        connection.close();
        return id;
    }

    public List<Prescription> getPrescriptionByStatus() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String selectQuery = "SELECT * from prescription WHERE status=waiting";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        List<Prescription> prescriptions = new ArrayList<>();
        while (resultSet.next()) {
            Prescription prescription = new Prescription(resultSet.getInt(1),
                    resultSet.getDate(2), new Patient(resultSet.getString(3)),
                    new Doctor(resultSet.getString(5)), PrescriptionStatus.valueOf(resultSet.getString(4)));
            prescriptions.add(prescription);
        }
        connection.close();
        return prescriptions;
    }

    public void updatePrescriptionStatus(Prescription prescription) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String updateQuery = "UPDATE prescription set status=? where id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setString(1, prescription.getPrescriptionStatus().toString());
        preparedStatement.setInt(2, prescription.getId());
        preparedStatement.executeUpdate();
        connection.close();
    }

    public Prescription getPrescriptionByUserId(String userId) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String selectQuery = "SELECT * from prescription WHERE user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setString(1, userId);
        ResultSet resultSet = preparedStatement.executeQuery();
        Prescription prescription = new Prescription(resultSet.getInt(1),
                resultSet.getDate(2), new Patient(resultSet.getString(3)),
                new Doctor(resultSet.getString(5)), PrescriptionStatus.valueOf(resultSet.getString(4)));
        connection.close();
        return prescription;
    }

    public boolean deletePrescription(String userId) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String deleteQuery = "DELETE from prescription WHERE user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setString(1, userId);
        int result = preparedStatement.executeUpdate();
        connection.close();
        return result >= 1;
    }

    public boolean updateDate(Date date, String userId) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String updateQuery = "UPDATE prescription set date=? WHERE user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setDate(1, date);
        preparedStatement.setString(2, userId);
        int result = preparedStatement.executeUpdate();
        return result >= 1;
    }

    public boolean updateStatusAfterPrescriptionUpdate(String userId) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String updateQuery = "UPDATE prescription set status=default WHERE user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
        preparedStatement.setString(1, userId);
        int result = preparedStatement.executeUpdate();
        return result >= 1;
    }
}
