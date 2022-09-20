package ir.maktab.hw7.servic;

import ir.maktab.hw7.modle.Medicine;
import ir.maktab.hw7.repository.MedicineRepository;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService{
    private static AdminServiceImpl adminService;

    private AdminServiceImpl() {
    }

    public static AdminServiceImpl getInstance() {
        if (adminService == null)
            adminService = new AdminServiceImpl();
        return adminService;
    }
    MedicineRepository medicineRepository=MedicineRepository.getInstance();
    @Override
    public boolean addMedicine(Medicine medicine) throws SQLException {
       return medicineRepository.addMedicine(medicine);
    }

    @Override
    public Integer calculatePriceWithInsurance(int basePrice) {
        int finalPrice= (int) (basePrice * 9.0);
        return finalPrice;
    }

}
