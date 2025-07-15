package com.bankingsystem.dao.imp;

import com.bankingsystem.dao.LoanCustomerDao;
import com.bankingsystem.entity.LoanCustomerEntity;
import com.bankingsystem.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanCustomerDaoImp implements LoanCustomerDao {

    private Connection conn = null;
    private PreparedStatement pstmt = null;

    @Override
    public Integer addcustomer(LoanCustomerEntity entity) {
        int generatedId = -1;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement(
                    "INSERT INTO Customer (name, email, phone, address, dob) VALUES (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS
            );

            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getEmail());
            pstmt.setString(3, entity.getPhone());
            pstmt.setString(4, entity.getAddress());
            pstmt.setDate(5, entity.getDob() != null ? new java.sql.Date(entity.getDob().getTime()) : null);

            int res = pstmt.executeUpdate();

            if (res > 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    generatedId = rs.getInt(1); // Assuming the ID is the first column
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error adding customer", e);
        }

        return generatedId;
    }


    @Override
    public String updateCustomer(LoanCustomerEntity entity) {

        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("UPDATE Customer SET name = ?, email = ?, phone = ?, address = ?, dob = ? WHERE cust_id = ?");

            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getEmail());
            pstmt.setString(3, entity.getPhone());
            pstmt.setString(4, entity.getAddress());
            //pstmt.setDate(5,entity.getDob());
            pstmt.setDate(5, entity.getDob() != null ? new java.sql.Date(entity.getDob().getTime()) : null);
            pstmt.setInt(6, entity.getCustomerId());

            int res = pstmt.executeUpdate();
            return res + " row(s) updated";

        } catch (SQLException e) {
            throw new RuntimeException("Error updating customer", e);
        }
    }

    @Override
    public List<LoanCustomerEntity> getAllCustomers() {
        List<LoanCustomerEntity> list = new ArrayList<>();


        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("SELECT * FROM Customer");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LoanCustomerEntity entity = new LoanCustomerEntity();
                entity.setCustomerId(rs.getInt("cust_id"));
                entity.setName(rs.getString("name"));
                entity.setEmail(rs.getString("email"));
                entity.setPhone(rs.getString("phone"));
                entity.setAddress(rs.getString("address"));
                entity.setDob(String.valueOf(rs.getDate("dob")));
                list.add(entity);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }

        return list;
    }

    @Override
    public LoanCustomerEntity getCustomer(Integer id) {

        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("SELECT * FROM Customer WHERE cust_id = ?");

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    LoanCustomerEntity entity = new LoanCustomerEntity();
                    entity.setCustomerId(rs.getInt("cust_id"));
                    entity.setName(rs.getString("name"));
                    entity.setEmail(rs.getString("email"));
                    entity.setPhone(rs.getString("phone"));
                    entity.setAddress(rs.getString("address"));
                    entity.setDob(rs.getString("dob"));
                    return entity;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customer", e);
        }

        return null;
    }

    @Override
    public String deleteCustomer(Integer id) {

        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("DELETE FROM Customer WHERE cust_id = ?");

            pstmt.setInt(1, id);
            int res = pstmt.executeUpdate();
            return res + " row(s) deleted";

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting customer", e);
        }
    }
}
