package ir.maktab.hw7;

import ir.maktab.hw7.modle.Medicine;
import ir.maktab.hw7.servic.AdminService;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        MainHandler.menu();
    }
}
