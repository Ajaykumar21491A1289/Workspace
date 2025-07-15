package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe"; // Adjust as needed
        String username = "your_username";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password)) {
            System.out.println("Connected to Oracle database!");
        } catch (SQLException e) {
            System.out.println("Connection failed: " + e.getMessage());
        }
    }
}
