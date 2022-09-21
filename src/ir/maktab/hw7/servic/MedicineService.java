package ir.maktab.hw7.servic;

import ir.maktab.hw7.modle.Medicine;
import ir.maktab.hw7.repository.MedicineRepository;

import java.sql.SQLException;
import java.util.List;

public class MedicineService {
    private static MedicineService medicineService;

    private MedicineService() {
    }

    public static MedicineService getInstance() {
        if (medicineService == null)
            medicineService = new MedicineService();
        return medicineService;
    }
    MedicineRepository medicineRepository = MedicineRepository.getInstance();
    public Boolean deleteMedicine(Medicine medicine) throws SQLException {
        return medicineRepository.deleteMedicine(medicine);
    }
    public boolean addMedicine(Medicine medicine) throws SQLException {
        return medicineRepository.addMedicine(medicine);
    }
    public List<Medicine> getMedicines(int id) throws SQLException {
        return medicineRepository.getMedicines(id);
    }
    public Integer getId(Medicine medicine) throws SQLException {
        return medicineRepository.getId(medicine);
    }
}

