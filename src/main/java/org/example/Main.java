package org.example;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        connnect("mydatabase","postgres","postgres");

    }
    public static void connnect(String dbName, String userName, String password) throws Exception {
        String url = "jdbc:postgresql://localhost:5432/" + dbName;
        Connection con = DriverManager.getConnection(url, userName, password);
        Statement st = con.createStatement();
        System.out.print("Lütfen işlem yapmak istediğiniz tablo ismini giriniz:");
        String table = scanner.nextLine();
        System.out.print("Lütfen listelenmesini istediğiniz sütun ismini giriniz:");
        String row = scanner.nextLine();
        ResultSet rs2 = st.executeQuery("SELECT COUNT(" + row + ") FROM " + table);
        rs2.next();
        String[] name = new String[Integer.parseInt(rs2.getString(1))];
        ResultSet rs = st.executeQuery("SELECT " + row + " FROM " + table);
        rs.next();
        Thread.sleep(3000);
        System.out.println("Bağlantı kuruldu...");
        Thread.sleep(1000);
        for (int i=0; i< name.length; i++){
            name[i] = rs.getString(1);
            rs.next();
        }
        Arrays.stream(name).forEach(System.out::println);

    }
}