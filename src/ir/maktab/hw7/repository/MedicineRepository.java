package ir.maktab.hw7.repository;

import ir.maktab.hw7.modle.Medicine;

import java.sql.*;

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
        Connection connection=ConnectionGate.getConnection();
        String insertQuery="INSERT into medicine (name,producer,classification,insurance_support,otc,price) VALUES(?,?,?,?,?,?)";
        PreparedStatement preparedStatement= connection.prepareStatement(insertQuery);
        preparedStatement.setString(1,medicine.getName());
        preparedStatement.setString(2,medicine.getProducerCompany());
        preparedStatement.setString(3,medicine.getClassification());
        preparedStatement.setBoolean(4,medicine.getSupportByInsurance());
        preparedStatement.setBoolean(5,medicine.getOTC());
        preparedStatement.setInt(6,medicine.getPrice());
        int result=preparedStatement.executeUpdate();
        return result>=1;
    }
    public Integer getId(Medicine medicine) throws SQLException {
        Connection connection=ConnectionGate.getConnection();
        String selectQuery="SELECT id from medicine WHERE \"name\"=? AND dose=?";
        PreparedStatement preparedStatement= connection.prepareStatement(selectQuery);
        preparedStatement.setString(1,medicine.getName());
        preparedStatement.setInt(2,medicine.getDose());
        ResultSet resultSet=preparedStatement.executeQuery();
        resultSet.next();
        int result=resultSet.getInt("id");
        return result;
    }
}
