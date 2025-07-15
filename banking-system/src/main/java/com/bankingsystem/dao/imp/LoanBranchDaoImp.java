package com.bankingsystem.dao.imp;

import com.bankingsystem.dao.LoanBranchDao;
import com.bankingsystem.entity.LoanBranchEntity;
import com.bankingsystem.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanBranchDaoImp implements LoanBranchDao {

    private Connection conn = null;
    private PreparedStatement pstmt = null;


    @Override
    public String addBranch(LoanBranchEntity entity) {

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO Branch (name, address, state) VALUES (?, ?, ?)");

            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getAddress());
            pstmt.setString(3, entity.getState());

            int result = pstmt.executeUpdate();
            return result + " row(s) inserted.";
        } catch (SQLException e) {
            throw new RuntimeException("Error adding branch", e);
        }
    }

    @Override
    public List<LoanBranchEntity> getAllBranches() {
        List<LoanBranchEntity> branches = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM Branch");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                LoanBranchEntity entity = new LoanBranchEntity();
                entity.setBranchId(rs.getInt("branch_id"));
                entity.setName(rs.getString("name"));
                entity.setAddress(rs.getString("address"));
                entity.setState(rs.getString("state"));
                branches.add(entity);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving branches", e);
        }

        return branches;
    }

    @Override
    public LoanBranchEntity getBranch(int id) {

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM Branch WHERE branch_id = ?");

            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    LoanBranchEntity entity = new LoanBranchEntity();
                    entity.setBranchId(rs.getInt("branch_id"));
                    entity.setName(rs.getString("name"));
                    entity.setAddress(rs.getString("address"));
                    entity.setState(rs.getString("state"));
                    return entity;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving branch", e);
        }

        return null;
    }

    @Override
    public String updateBranch(LoanBranchEntity entity) {

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("UPDATE Branch SET name = ?, address = ?, state = ? WHERE branch_id = ?");

            pstmt.setString(1, entity.getName());
            pstmt.setString(2, entity.getAddress());
            pstmt.setString(3, entity.getState());
            pstmt.setInt(4, entity.getBranchId());

            int result = pstmt.executeUpdate();
            return result + " row(s) updated.";
        } catch (SQLException e) {
            throw new RuntimeException("Error updating branch", e);
        }
    }

    @Override
    public String deleteBranch(int id) {

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("DELETE FROM Branch WHERE branch_id = ?");

            pstmt.setInt(1, id);
            int result = pstmt.executeUpdate();
            return result + " row(s) deleted.";
        } catch (SQLException e) {
            throw new RuntimeException("Error deleting branch", e);
        }
    }
}
