package ir.maktab.hw7;

import ir.maktab.hw7.modle.Doctor;
import ir.maktab.hw7.modle.Medicine;
import ir.maktab.hw7.modle.Patient;
import ir.maktab.hw7.modle.Prescription;
import ir.maktab.hw7.servic.AdminServiceImpl;
import ir.maktab.hw7.servic.UserServiceImpl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHandler {
    public static Scanner scanner = new Scanner(System.in);

    public static void menu() throws SQLException {
        UserServiceImpl userService = UserServiceImpl.getInstance();
        System.out.println("hello please enter: \n 1-sign up \n 2-log in \n 3-log out");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                Patient patient = new Patient();
                System.out.println("enter your name");
                String name = scanner.nextLine();
                patient.setFirstName(name);
                patient.setUserName(name);
                System.out.println("enter your family");
                patient.setLastName(scanner.nextLine());
                System.out.println("enter your national code");
                String nationalCode = scanner.nextLine();
                patient.setNationalCode(nationalCode);
                patient.setPassword(nationalCode);
                System.out.println("do you have social security insurance enter yes or no");
                if (scanner.nextLine().equals("yes"))
                    patient.setInsurance(true);
                patient.setInsurance(false);
                System.out.println("enter your exact address");
                patient.setAddress(scanner.nextLine());
                if (userService.register(patient))
                    System.out.println("register be successful:\n your username is your firstName \n your Password is your nationalCode" +
                            "you can change your userName after logIn");
                else System.out.println("register failed try again");
                break;
            case 2:
                System.out.println("enter your userName:");
                String userName = scanner.nextLine();
                System.out.println("enter your password");
                String password = scanner.nextLine();
                patient = userService.logIN(userName, password);
                if (patient == null) {
                    System.out.println("userName or password is wrong");
                    break;
                }
                System.out.println("hello" + userName + "what do you want: \n 1-buy with doctor prescription \n 2-buy without prescription");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        Prescription prescription = new Prescription();
                        prescription.setPatient(patient);
                        prescription.setMedicines(getMedicinesList());
                    case 2:
                        prescription.setPatient(patient);
                        Doctor doctor = new Doctor();
                        System.out.println("enter your prescription date");
                        prescription.setDate(Date.valueOf(scanner.nextLine()));
                        System.out.println("enter your doctor firstName:");
                        doctor.setFirstName(scanner.nextLine());
                        System.out.println("enter your doctor lastName");
                        doctor.setLastName(scanner.nextLine());
                        System.out.println("enter your doctor specialist like:circulatory specialist");
                        doctor.setSpecialist(scanner.nextLine());
                        System.out.println("enter you doctor GMCNumber,you can find it as fifth number in doctor seal");
                        doctor.setGMCNumber(scanner.nextLine());
                        prescription.setDoctor(doctor);
                        prescription.setMedicines(getMedicinesList());
                }
        }
    }

    public static void adminMain() throws SQLException {
        AdminServiceImpl adminService = AdminServiceImpl.getInstance();
        System.out.println("chose:\n 1-add medicine \n 2-delete medicine \n 3-confirm prescription \n");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
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

    public static List<Medicine> getMedicinesList() {
        List<Medicine> medicines = new ArrayList<>();
        int countOrders = 1;
        do {
            Medicine medicine = new Medicine();
            System.out.println("enter name of what you need");
            medicine.setName(scanner.nextLine());
            System.out.println("enter the medicine dose(if it drug)");
            medicine.setDose(Integer.parseInt(scanner.nextLine()));
            System.out.println("how many" + medicine.getName() + "do you want");
            int count = Integer.parseInt(scanner.nextLine());
            medicines.add(medicine);
            System.out.println(countOrders + "item add \n if your order finish press q else press enter to continue");
        } while (!scanner.nextLine().equals("q"));
        return medicines;
    }
}

