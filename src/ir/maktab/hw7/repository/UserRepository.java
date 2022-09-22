package ir.maktab.hw7.repository;

import ir.maktab.hw7.modle.Patient;

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
        String insertQuery = "INSERT into \"user\" (first_name,last_name,national_code,address) Values (?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
        preparedStatement.setString(1, patient.getFirstName());
        preparedStatement.setString(2, patient.getLastName());
        preparedStatement.setString(3, patient.getNationalCode());
        preparedStatement.setString(5, patient.getAddress());
        int result = preparedStatement.executeUpdate();
        connection.close();
        return result >= 1;
    }

    public Patient selectUser(String userName, String password) throws SQLException {
        Connection connection = ConnectionGate.getConnection();
        String selectQuery = "SELECT * from \"user\" where user_name=? and national_code=?";
        PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);
        preparedStatement.setString(1, userName);
        preparedStatement.setString(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        Patient patient = new Patient(resultSet.getString("first_name"), resultSet.getString("last_name"),
                resultSet.getString("national_code"),
                resultSet.getString("address"));
        connection.close();
        return patient;
    }

}
