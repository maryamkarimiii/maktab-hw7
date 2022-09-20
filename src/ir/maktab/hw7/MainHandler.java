package ir.maktab.hw7;

import ir.maktab.hw7.modle.Patient;
import ir.maktab.hw7.servic.PatientServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class MainHandler {
    public static Scanner scanner = new Scanner(System.in);

    public static void menu() throws SQLException {
        PatientServiceImpl patientService = PatientServiceImpl.getInstance();
        System.out.println("hello please enter: \n 1-sign up \n 2-log in \n 3-log out");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                Patient patient = new Patient();
                System.out.println("enter your name");
                patient.setFirstName(scanner.nextLine());
                System.out.println("enter your family");
                patient.setLastName(scanner.nextLine());
                System.out.println("enter your national code");
                patient.setNationalCode(scanner.nextLine());
                System.out.println("do you have social security insurance enter yes or no");
                if (scanner.nextLine().equals("yes"))
                    patient.setInsurance(true);
                patient.setInsurance(false);
                System.out.println("enter your exact address");
                patient.setAddress(scanner.nextLine());
                if (patientService.register(patient))
                    System.out.println("register be successful");
                else System.out.println("register failed try again");
        }
        System.out.println("what do you want: \n 1-buy with prescription \n 2-buy without prescription");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:

        }
    }
}
