package com.example.softofertarefacturare.BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BazaDate {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/?user=root";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectare reușită la baza de date!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Eroare la conectarea la baza de date!");
        }
        return connection;
}

}
