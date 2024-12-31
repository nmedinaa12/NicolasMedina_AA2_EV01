package com.finanzas.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/finanzas"; // Cambia "tu_base_de_datos"
    private static final String USER = "root"; 
    private static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection()) {
            if (conn != null) {
                System.out.println("Conexión exitosa");
            } else {
                System.out.println("Conexión fallida");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
