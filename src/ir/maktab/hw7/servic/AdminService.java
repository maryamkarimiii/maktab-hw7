package ir.maktab.hw7.servic;

import ir.maktab.hw7.modle.Medicine;

import java.sql.SQLException;

public interface AdminService {
    boolean addMedicine(Medicine medicine) throws SQLException;
    Integer calculatePriceWithInsurance(int basePrice);
}
