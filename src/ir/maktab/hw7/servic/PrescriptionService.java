package ir.maktab.hw7.servic;

import ir.maktab.hw7.modle.Medicine;
import ir.maktab.hw7.modle.Patient;
import ir.maktab.hw7.modle.Prescription;
import ir.maktab.hw7.repository.PrescriptionRepository;

import java.sql.SQLException;

public class PrescriptionService {
    private static PrescriptionService prescriptionService;

    private PrescriptionService() {
    }

    public static PrescriptionService getInstance() {
        if (prescriptionService == null)
            prescriptionService = new PrescriptionService();
        return prescriptionService;
    }

    PrescriptionRepository prescriptionRepository = PrescriptionRepository.getInstance();
    public Integer addPrescription(Prescription prescription) throws SQLException {
      return prescriptionRepository.addPrescription(prescription);
    }
    public Prescription showConfirmedPrescription(String userId) throws SQLException {
       return prescriptionRepository.getPrescriptionByUserId(userId);
    }
}
