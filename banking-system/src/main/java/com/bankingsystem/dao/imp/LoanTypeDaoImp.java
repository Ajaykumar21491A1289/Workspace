package com.bankingsystem.dao.imp;

import com.bankingsystem.dao.LoanTypeDao;
import com.bankingsystem.entity.LoanTypeEntity;
import com.bankingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanTypeDaoImp implements LoanTypeDao {

    private Connection conn = null;
    private PreparedStatement pstmt = null;

    public String addLoanType(LoanTypeEntity entity) {

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("insert into Loan_type(type_name,intrest_rate) values(?,?)");
            pstmt.setString(1, entity.getLoanType());
            pstmt.setFloat(2, entity.getIntrestRate());
            int res = pstmt.executeUpdate();
            return res + " rows inserted Successfully";
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public String updateLoanType(LoanTypeEntity entity) {

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update  Loan_type set type_name=? , intrest_rate =? where loan_type_id=?");
            pstmt.setString(1, entity.getLoanType());
            pstmt.setFloat(2, entity.getIntrestRate());
            pstmt.setInt(3, entity.getLoanTypeId());
            int res = pstmt.executeUpdate();
            return res + " rows Updated Successfully";
        } catch (SQLException e) {
            throw new RuntimeException();
        }


    }

    public List<LoanTypeEntity> getAllLaonTypes() {
        List<LoanTypeEntity> list = new ArrayList<>();

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from Loan_type");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                LoanTypeEntity entity = new LoanTypeEntity();
                entity.setLoanTypeId(rs.getInt("loan_type_id"));
                entity.setLoanType(rs.getString("type_name"));
                entity.setIntrestRate(rs.getFloat("intrest_rate"));
                list.add(entity);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException();
        }

    }

    public LoanTypeEntity getLoanType(Integer id) {
        LoanTypeEntity entity = null;

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("select * from Loan_type where loan_type_id=?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                entity = new LoanTypeEntity();
                entity.setLoanTypeId(rs.getInt("loan_type_id"));
                entity.setLoanType(rs.getString("type_name"));
                entity.setIntrestRate(rs.getFloat("intrest_rate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return entity;
    }


    public String deleteLaonType(Integer id) {
        conn = DBConnection.getConnection();
        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("delete from Loan_type where loan_type_id=?");
            pstmt.setInt(1, id);
            int res = pstmt.executeUpdate();
            return res + " rows Deleted Successfully";
        } catch (SQLException e) {
            throw new RuntimeException();
        }


    }
}
