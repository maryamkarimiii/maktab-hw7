package ir.maktab.hw7;

import ir.maktab.hw7.modle.Patient;
import ir.maktab.hw7.servic.UserServiceImpl;

import java.sql.SQLException;
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
                if (userService.logIN(userName, password) == null) {
                    System.out.println("userName or password is wrong");
                    break;
                }
                System.out.println("hello" + userName + "what do you want: \n 1-buy with prescription \n 2-buy without prescription");
                switch (Integer.parseInt(scanner.nextLine())){
                    case 1:


                }


        }
    }
}
