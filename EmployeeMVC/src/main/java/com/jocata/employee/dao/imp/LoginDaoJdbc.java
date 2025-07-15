package com.jocata.employee.dao.imp;

import com.jocata.employee.dao.LoginDao;
import com.jocata.employee.entity.EmployeeEntity;

import java.sql.*;

public class LoginDaoJdbc implements LoginDao {
    static Connection conn;

    static {
        String url = "jdbc:mysql://localhost:3306/jocata";
        String user = "root";
        String password = "21491A1289";

        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection failed", e);
        }
    }

    public void addEmployee(EmployeeEntity entity) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("INSERT INTO employee VALUES (?, ?, ?, ?, ?, ?);");
            pstmt.setInt(1, entity.getId());
            pstmt.setString(2, entity.getUserName());
            pstmt.setString(3, entity.getDesignation());
            pstmt.setInt(4, entity.getSalary());
            pstmt.setDate(5, entity.getDateOfJoin());
            pstmt.setDate(6, entity.getDateOfBirth());

            int result = pstmt.executeUpdate();
            System.out.println(result + " row(s) inserted.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(null, pstmt);
        }
    }

    public String searchEmployee(String id) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement("SELECT empname FROM employee WHERE empid=?;");
            pstmt.setInt(1, Integer.parseInt(id));
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            } else {
                return "Employee not found.";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(rs, pstmt);
        }
    }

    public String deleteEmployee(String id) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("DELETE FROM employee WHERE empid=?;");
            pstmt.setInt(1, Integer.parseInt(id));
            int res = pstmt.executeUpdate();
            return res + " rows deleted.";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(null, pstmt);
        }
    }

    public String updateEmployee(EmployeeEntity entity) {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement("UPDATE employee SET empname=?, empdesignation=?, empsalary=?, empdoj=?, empdob=? WHERE empid=?;");
            pstmt.setString(1, entity.getUserName());
            pstmt.setString(2, entity.getDesignation());
            pstmt.setInt(3, entity.getSalary());
            pstmt.setDate(4, entity.getDateOfJoin());
            pstmt.setDate(5, entity.getDateOfBirth());
            pstmt.setInt(6, entity.getId());

            int res = pstmt.executeUpdate();
            return res + " row(s) updated.";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeResources(null, pstmt);
        }
    }

    public static void closeResources(ResultSet rs, PreparedStatement pstmt) {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
