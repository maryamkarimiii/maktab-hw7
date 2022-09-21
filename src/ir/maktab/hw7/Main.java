package ir.maktab.hw7;

import ir.maktab.hw7.modle.Medicine;
import ir.maktab.hw7.modle.Prescription;
import ir.maktab.hw7.servic.AdminServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        AdminServiceImpl adminService=AdminServiceImpl.getInstance();
        Medicine medicine = new Medicine();
        System.out.println("enter medicine name");
        medicine.setName(scanner.nextLine());
        System.out.println("enter medicine company");
        medicine.setProducerCompany(scanner.nextLine());
        System.out.println("enter medicine classification");
        medicine.setClassification(scanner.nextLine());
        System.out.println("enter the medicine dose(if it drug)");
        medicine.setDose(Integer.parseInt(scanner.nextLine()));
        System.out.println("is it support by insurance? true or false");
        medicine.setSupportByInsurance(scanner.nextBoolean());
        System.out.println("is it OTC? true or false");
        medicine.setOTC(scanner.nextBoolean());
        scanner.nextLine();
        System.out.println("enter its price");
        medicine.setPrice(Integer.parseInt(scanner.nextLine()));
        if (adminService.addMedicine(medicine))
            System.out.println("add medicine be successful");
        else System.out.println("not be successful try another time");
       }
}
