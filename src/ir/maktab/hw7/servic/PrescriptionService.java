package ir.maktab.hw7.servic;

import ir.maktab.hw7.modle.Medicine;
import ir.maktab.hw7.modle.Prescription;
import ir.maktab.hw7.repository.PrescriptionRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

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

    public Prescription showPrescription(String userId) throws SQLException {
        return prescriptionRepository.getPrescriptionByUserId(userId);
    }

    public boolean deletePrescription(String userId) throws SQLException {
        return prescriptionRepository.deletePrescription(userId);
    }

    public Integer calculateTotalPrice(List<Medicine> medicines) {
        int totalPrice = 0;
        for (Medicine medicine : medicines) {
            totalPrice += medicine.getPrice();
        }
        return totalPrice;
    }

    public boolean updateDate(Date date, String userId) throws SQLException {
        return prescriptionRepository.updateDate(date, userId);
    }
}
