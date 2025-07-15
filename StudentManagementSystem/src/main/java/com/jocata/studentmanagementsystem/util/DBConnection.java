package com.jocata.studentmanagementsystem.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


        private static String url = "jdbc:mysql://localhost:3306/studentmanagementsystem";
        private static String user = "root";
        private static String password = "21491A1289";

        public static Connection getConnection () {
            try {
                return DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

}
