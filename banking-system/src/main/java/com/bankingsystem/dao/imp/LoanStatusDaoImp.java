package com.bankingsystem.dao.imp;

import com.bankingsystem.dao.LoanStatusDao;
import com.bankingsystem.entity.LoanStatusEntity;
import com.bankingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanStatusDaoImp implements LoanStatusDao {

    private Connection conn = null;
    private PreparedStatement pstmt = null;


    @Override
    public String addLaonStatus(LoanStatusEntity entity) {


        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("insert into Loan_status(status_name) values(?)");
            pstmt.setString(1, entity.getStatusName());
            int res = pstmt.executeUpdate();
            return res + "rows inserted";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public String updateLoanStatus(LoanStatusEntity entity) {

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update  Loan_status set status_name=? where status_id=?");
            pstmt.setString(1, entity.getStatusName());
            pstmt.setInt(2, entity.getStatusId());
            int res = pstmt.executeUpdate();
            return res + "rows inserted";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public List<LoanStatusEntity> getAllLoanStatus() {
        List<LoanStatusEntity> entity = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from Loan_Status");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                LoanStatusEntity loanEntity = new LoanStatusEntity();
                loanEntity.setStatsId(rs.getInt("status_id"));
                loanEntity.setStatusName(rs.getString("status_name"));
                entity.add(loanEntity);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }

    public String getLoan(Integer id) {

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select status_name from Loan_Status where status_id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("status_id") + " " + rs.getString("status_name");
            } else {
                return "No loan status found for ID: " + id;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public String deleteLoan(Integer id) {

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("DELETE FROM Loan_status WHERE status_id = ?");
            pstmt.setInt(1, id);
            int res = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return res + " row(s) deleted";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
