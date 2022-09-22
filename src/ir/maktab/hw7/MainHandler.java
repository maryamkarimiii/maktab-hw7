package ir.maktab.hw7;

import ir.maktab.hw7.modle.Doctor;
import ir.maktab.hw7.modle.Medicine;
import ir.maktab.hw7.modle.Patient;
import ir.maktab.hw7.modle.Prescription;
import ir.maktab.hw7.servic.AdminService;
import ir.maktab.hw7.servic.UserService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainHandler {
    public static Scanner scanner = new Scanner(System.in);

    public static void menu() throws SQLException {
        UserService userService = UserService.getInstance();
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
                if (userName.equals("admin") && password.equals("pharmacyAdmin1")) {
                    adminMain();
                } else {
                    patientMain(userName, password);
                }
        }
    }

    public static void adminMain() throws SQLException {
        AdminService adminService = AdminService.getInstance();
        System.out.println("chose:\n 1-add medicine \n 2-delete medicine \n 3-confirm prescription \n 4-change medicine exist");
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
                System.out.println("is it OTC? true or false");
                medicine.setOTC(scanner.nextBoolean());
                scanner.nextLine();
                System.out.println("enter its price");
                medicine.setPrice(Integer.parseInt(scanner.nextLine()));
                if (adminService.addMedicine(medicine))
                    System.out.println("add medicine be successful");
                else System.out.println("not be successful try another time");
                break;
            case 2:
                Medicine medicine1 = new Medicine();
                System.out.println("enter medicine name");
                medicine1.setName(scanner.nextLine());
                System.out.println("enter medicine company");
                medicine1.setProducerCompany(scanner.nextLine());
                System.out.println("enter the medicine dose(if it drug)");
                medicine1.setDose(Integer.parseInt(scanner.nextLine()));
                if (adminService.deleteMedicine(medicine1))
                    System.out.println("delete successfully");
                else System.out.println("not be successfully ");
                break;
            case 3:
                adminService.confirmPrescription();
                System.out.println(adminService.confirmPrescription() + "prescription are checked");
                break;
            case 4:
                Medicine medicine2 = new Medicine();
                System.out.println("enter medicine name");
                medicine2.setName(scanner.nextLine());
                System.out.println("enter medicine company");
                medicine2.setProducerCompany(scanner.nextLine());
                System.out.println("enter the medicine dose(if it drug)");
                medicine2.setDose(Integer.parseInt(scanner.nextLine()));
                if (adminService.updateMedicineExistence(medicine2))
                    System.out.println("exist change to false");
                else System.out.println("not successfully");
        }
    }

    public static void patientMain(String userName, String password) throws SQLException {
        UserService userService = UserService.getInstance();
        Patient patient;
        patient = userService.logIN(userName, password);
        if (patient == null) {
            System.out.println("userName or password is wrong");
            return;
        }
        System.out.println("hello" + userName + "what do you want: \n 1-buy with doctor prescription \n 2-buy without prescription \n" +
                "3-see confirmed prescription \n 4-edite prescription \n 5-delete prescription");
        switch (Integer.parseInt(scanner.nextLine())) {
            case 1:
                Prescription prescription = new Prescription();
                prescription.setPatient(patient);
                getMedicinesList(userService.addPrescription(prescription));
                break;
            case 2:
                Prescription prescription1 = new Prescription();
                prescription1.setPatient(patient);
                Doctor doctor = new Doctor();
                System.out.println("enter your prescription date");
                prescription1.setDate(Date.valueOf(scanner.nextLine()));
                System.out.println("enter your doctor firstName:");
                doctor.setFirstName(scanner.nextLine());
                System.out.println("enter your doctor lastName");
                doctor.setLastName(scanner.nextLine());
                System.out.println("enter your doctor specialist like:circulatory specialist");
                doctor.setSpecialist(scanner.nextLine());
                System.out.println("enter you doctor GMCNumber,you can find it as fifth number in doctor seal");
                doctor.setGMCNumber(scanner.nextLine());
                prescription1.setDoctor(doctor);
                getMedicinesList(userService.addPrescription(prescription1));
                break;
            case 3:
                System.out.println(userService.showConfirmedPrescription(password));
                break;
            case 4:
                System.out.println("chose:\n 1-update date\n 2-update items\n ");
                switch (Integer.parseInt(scanner.nextLine())) {
                    case 1:
                        System.out.println("enter your new date");
                        if (userService.updateDate(Date.valueOf(scanner.nextLine()), password)) {
                            userService.editePrescription(password);
                            System.out.println("update successfully");
                        }
                    case 2:
                        System.out.println(userService.showPrescription(password));
                        System.out.println("enter drug names you want to delete");
                        for (Medicine medicine : userService.showPrescription(password)) {
                            if (medicine.getName().equals(scanner.nextLine()))
                                userService.showPrescription(password).remove(medicine);
                        }
                        userService.editePrescription(password);
                }
                break;
            case 5:
                if (userService.deletePrescription(password))
                    System.out.println("delete prescription successfully");
                else System.out.println("the delete failed try again");

        }
    }

    public static List<Medicine> getMedicinesList(int id) throws SQLException {
        List<Medicine> medicines = new ArrayList<>();
        AdminService adminService = AdminService.getInstance();
        int countOrders = 0;
        do {
            Medicine medicine = new Medicine();
            System.out.println("enter name of what you need");
            medicine.setName(scanner.nextLine());
            System.out.println("enter the medicine dose(if it drug)");
            medicine.setDose(Integer.parseInt(scanner.nextLine()));
            System.out.println("how many" + medicine.getName() + "do you want");
            int count = Integer.parseInt(scanner.nextLine());
            medicine.setPrescription_id(id);
            medicines.add(medicine);
            countOrders++;
            System.out.println(countOrders + "item add \n if your order finish press q else press enter to continue\n" +
                    "notice:you can enter" + (10 - countOrders) + "items more");
        } while (!scanner.nextLine().equals("q") && countOrders < 10);
        return medicines;
    }
}

