package ir.maktab.hw7;

import ir.maktab.hw7.modle.Medicine;
import ir.maktab.hw7.modle.Prescription;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        Prescription prescription=new Prescription();
        Medicine medicine=new Medicine();
        int countOrders=1;
        do {
            System.out.println("enter name of what you need");
            medicine.setName(scanner.nextLine());
            System.out.println("enter the medicine dose(if it drug)");
            medicine.setDose(Integer.parseInt(scanner.nextLine()));
            System.out.println("how many" + medicine.getName() + "do you want");
            int count=Integer.parseInt(scanner.nextLine());
            System.out.println(countOrders + "item add \n if your order finish press q to finish");
        } while (!scanner.nextLine().equals("q"));
    }
}
