package ir.maktab.hw7.repository;

import ir.maktab.hw7.modle.Medicine;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicineRepository {
    private static MedicineRepository medicineRepository;

    private MedicineRepository() {
    }

    public static MedicineRepository getInstance() {
        if (medicineRepository == null)
            medicineRepository = new MedicineRepository();
        return medicineRepository;
    }

    public boolean addMedicine(Medicine medicine) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String insertQuery = "INSERT into medicine (name,producer,classification,otc,price) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, medicine.getName());
        preparedStatement.setString(2, medicine.getProducerCompany());
        preparedStatement.setString(3, medicine.getClassification());
        preparedStatement.setBoolean(5, medicine.getOTC());
        preparedStatement.setInt(6, medicine.getPrice());
        int result = preparedStatement.executeUpdate();
        return result >= 1;
    }

    public boolean deleteMedicine(Medicine medicine) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String deleteQuery = "DELETE from medicine WHERE name=? AND producer=? AND dose=?";
        PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
        preparedStatement.setString(1, medicine.getName());
        preparedStatement.setString(2, medicine.getProducerCompany());
        preparedStatement.setInt(3, medicine.getDose());
        int result = preparedStatement.executeUpdate();
        return result >= 1;
    }
    public boolean updateMedicineExistence(Medicine medicine) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String updateQuery="UPDATE medicine set is_exist=false WHERE name=? AND producer=? AND dose=?";
        PreparedStatement preparedStatement= connection.prepareStatement(updateQuery);
        preparedStatement.setString(1,medicine.getName());
        preparedStatement.setString(2,medicine.getProducerCompany());
        preparedStatement.setInt(3,medicine.getDose());
        int result= preparedStatement.executeUpdate();
        connection.close();
        return  result>=1;
    }

    public Integer getId(Medicine medicine) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String selectQuery = "SELECT id from medicine WHERE \"name\"=? AND dose=?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setString(1, medicine.getName());
        preparedStatement.setInt(2, medicine.getDose());
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        int result = resultSet.getInt("id");
        return result;
    }

    public List<Medicine> getMedicines(int id) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String selectQuery = "SELECT * from medicine WHERE prescription_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setInt(1, id);
        List<Medicine> medicines = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Medicine medicine = new Medicine(resultSet.getString(2), resultSet.getString(3),
                    resultSet.getString(4), resultSet.getInt(8), resultSet.getBoolean(6),
                    resultSet.getInt(7), resultSet.getBoolean(9), resultSet.getInt(10));
            medicines.add(medicine);
        }
        return medicines;
    }

    public List<Medicine> getMedicinesForPrescription(int id) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String selectQuery = "SELECT name,producer,price,dose from medicine WHERE prescription_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setInt(1, id);
        List<Medicine> medicines = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            Medicine medicine = new Medicine(resultSet.getString(2), resultSet.getString(3),
                    resultSet.getInt(8),
                    resultSet.getInt(7));
            medicines.add(medicine);
        }
        return medicines;
    }

}
