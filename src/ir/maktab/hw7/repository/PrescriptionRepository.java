package ir.maktab.hw7.repository;

import ir.maktab.hw7.modle.Prescription;

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
    public List<Prescription> selectPrescription() throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String selectQuery = "SELECT * from prescription WHERE confirm=false";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(selectQuery);
        List<Prescription> prescriptions = new ArrayList<>();
        while (resultSet.next()) {
            Prescription prescription = new Prescription()
        }
    }

    public Integer addPrescription(Prescription prescription) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String insertQuery = "INSERT into \"prescription\" (\"date\",user_id,flag) VALUES (?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setDate(1, (Date) prescription.getDate());
        preparedStatement.setString(2, prescription.getPatient().getNationalCode());
        preparedStatement.setBoolean(3, true);
        int result = preparedStatement.executeUpdate();
        int id=0;
        if(result>=1) {
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            id =resultSet.getInt("id");
        }
        connection.close();
        return id;
    }
}
