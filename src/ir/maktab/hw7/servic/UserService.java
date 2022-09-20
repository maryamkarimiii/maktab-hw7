package ir.maktab.hw7.servic;

import ir.maktab.hw7.modle.Patient;

import java.sql.SQLException;

public interface UserService {
    boolean register(Patient patient) throws SQLException;
    Patient logIN(String userName,String password) throws SQLException;

}
