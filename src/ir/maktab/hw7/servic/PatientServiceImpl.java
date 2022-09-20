package ir.maktab.hw7.servic;

import ir.maktab.hw7.modle.Patient;
import ir.maktab.hw7.repository.UserRepository;

import java.sql.SQLException;

public class PatientServiceImpl implements PatientService{
    private static PatientServiceImpl patientService;

    private PatientServiceImpl() {
    }

    public static PatientServiceImpl getInstance() {
        if (patientService == null)
            patientService = new PatientServiceImpl();
        return patientService;
    }
 UserRepository userRepository=UserRepository.getInstance();
    @Override
    public boolean register(Patient patient) throws SQLException {
       return userRepository.addUser(patient);
    }
}
