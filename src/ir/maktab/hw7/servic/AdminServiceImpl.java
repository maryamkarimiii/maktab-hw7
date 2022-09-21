package ir.maktab.hw7.servic;

import ir.maktab.hw7.modle.Medicine;
import ir.maktab.hw7.modle.Prescription;
import ir.maktab.hw7.modle.enums.PrescriptionStatus;
import ir.maktab.hw7.repository.PrescriptionRepository;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class AdminServiceImpl implements AdminService {
    private static AdminServiceImpl adminService;

    private AdminServiceImpl() {
    }

    public static AdminServiceImpl getInstance() {
        if (adminService == null)
            adminService = new AdminServiceImpl();
        return adminService;
    }

    MedicineService medicineService = MedicineService.getInstance();
    PrescriptionRepository prescriptionRepository = PrescriptionRepository.getInstance();

    @Override
    public boolean addMedicine(Medicine medicine) throws SQLException {
        return medicineService.addMedicine(medicine);
    }

    public Boolean deleteMedicine(Medicine medicine) throws SQLException {
        return medicineService.deleteMedicine(medicine);
    }

    @Override
    public Integer getMedicineId(Medicine medicine) throws SQLException {
        return medicineService.getId(medicine);
    }

    @Override
    public Integer confirmPrescription() throws SQLException {
        List<Prescription> prescriptions = prescriptionRepository.getPrescriptionByStatus();
        if (prescriptions.size() == 0)
            return 0;
        for (Prescription prescription : prescriptions) {
            if (expireDate(prescription.getDate()) && prescription.getDoctor() == null) {
                List<Medicine> medicines = medicineService.getMedicines(prescription.getId());
                for (Medicine medicine : medicines) {
                    if (medicine.getExist() && medicine.getOTC()) {
                        prescription.setPrescriptionStatus(PrescriptionStatus.CONFIRMED);
                        prescriptionRepository.updatePrescriptionStatus(prescription);
                    }
                }
            } else if (expireDate(prescription.getDate()) && prescription.getDoctor().getGMCNumber().length() == 5) {
                List<Medicine> medicines = medicineService.getMedicines(prescription.getId());
                for (Medicine medicine : medicines) {
                    if (medicine.getExist()) {
                        prescription.setPrescriptionStatus(PrescriptionStatus.CONFIRMED);
                        prescriptionRepository.updatePrescriptionStatus(prescription);
                    }
                }
            } else {
                prescription.setPrescriptionStatus(PrescriptionStatus.UNCONFIRMED);
                prescriptionRepository.updatePrescriptionStatus(prescription);
            }
        }
        return prescriptions.size();
    }

    public boolean expireDate(Date prescriptionDate) {
        Calendar prescriptionExpireDate = Calendar.getInstance();
        prescriptionExpireDate.setTime(prescriptionDate);
        prescriptionExpireDate.add(Calendar.MONTH, 1);
        Date nowDate = new Date();
        return prescriptionExpireDate.getTime().compareTo(nowDate) >= 0;
    }

}
