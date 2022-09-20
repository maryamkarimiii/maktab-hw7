package ir.maktab.hw7.repository;

import ir.maktab.hw7.modle.Patient;
import ir.maktab.hw7.modle.User;

import java.sql.*;

public class UserRepository {
    private static UserRepository userRepository;

    private UserRepository() {
    }

    public static UserRepository getInstance() {
        if (userRepository == null)
            userRepository = new UserRepository();
        return userRepository;
    }

    public boolean addUser(Patient patient) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String insertQuery = "INSERT into \"user\" (first_name,last_name,national_code,insurance,address) Values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, patient.getFirstName());
        preparedStatement.setString(2, patient.getLastName());
        preparedStatement.setString(3, patient.getNationalCode());
        preparedStatement.setBoolean(4, patient.isInsurance());
        preparedStatement.setString(5, patient.getAddress());
        int result = preparedStatement.executeUpdate();
        return result >=1;
    }
}
