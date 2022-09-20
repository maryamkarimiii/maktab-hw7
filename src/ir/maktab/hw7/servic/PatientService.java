package ir.maktab.hw7.servic;

import ir.maktab.hw7.modle.Patient;

import java.sql.SQLException;

public interface PatientService {
    boolean register(Patient patient) throws SQLException;

}
