package ir.maktab.hw7.servic;

import ir.maktab.hw7.modle.Medicine;
import ir.maktab.hw7.modle.Patient;
import ir.maktab.hw7.modle.Prescription;
import ir.maktab.hw7.repository.UserRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private static UserService userService;

    private UserService() {
    }

    public static UserService getInstance() {
        if (userService == null)
            userService = new UserService();
        return userService;
    }

    UserRepository userRepository = UserRepository.getInstance();
    PrescriptionService prescriptionService = PrescriptionService.getInstance();
    MedicineService medicineService = MedicineService.getInstance();

    public boolean register(Patient patient) throws SQLException {
        return userRepository.addUser(patient);
    }

    public Patient logIN(String userName, String password) throws SQLException {
        return userRepository.selectUser(userName, password);
    }

    public Integer addPrescription(Prescription prescription) throws SQLException {
        return prescriptionService.addPrescription(prescription);
    }

    public Prescription showConfirmedPrescription(String userId) throws SQLException {
        Prescription prescription = prescriptionService.showPrescription(userId);
        prescription.setMedicines(medicineService.getMedicinesForPrescription(prescription.getId()));
        prescription.setTotalPrice(prescriptionService.calculateTotalPrice(prescription.getMedicines()));
        return prescription;
    }

    public List<Medicine> showPrescription(String userId) throws SQLException {
        Prescription prescription = prescriptionService.showPrescription(userId);
        prescription.setMedicines(medicineService.getMedicinesForPrescription(prescription.getId()));
        return prescription.getMedicines();
    }

    public void editePrescription(String userId) throws SQLException {
        Prescription prescription = prescriptionService.showPrescription(userId);
    }

    public boolean deletePrescription(String userId) throws SQLException {
        return prescriptionService.deletePrescription(userId);
    }

    public boolean updateDate(Date date, String userId) throws SQLException {
        return prescriptionService.updateDate(date, userId);
    }
}
