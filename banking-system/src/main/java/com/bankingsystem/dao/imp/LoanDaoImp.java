package com.bankingsystem.dao.imp;

import com.bankingsystem.dao.LoanDao;
import com.bankingsystem.entity.LoanEntity;
import com.bankingsystem.entity.LoanResponseEntity;
import com.bankingsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanDaoImp implements LoanDao {
    Connection conn;
    PreparedStatement pstmt;
    ResultSet resultSet;
    @Override
    public String addLoan(LoanEntity entity) {
        try {

            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO Loan (customer_id,loan_type,branch_id,status_id,principal_amount,intrest_rate,term_months) VALUES (?, ?,?,?,?,?,?)");
            pstmt.setInt(1, entity.getCustomerID());
            pstmt.setInt(2,entity.getLoanTypeId());
            pstmt.setInt(3,entity.getBranchId());
            pstmt.setInt(4,entity.getStatusId());
            pstmt.setFloat(5,entity.getPrincipalAmount());
            pstmt.setFloat(6,entity.getIntrestRate());
            pstmt.setInt(7,entity.getTermMonths());

            int result = pstmt.executeUpdate();
            pstmt=null;
            return result + " row(s) inserted.";
        } catch (SQLException e) {
            throw new RuntimeException("Error adding branch", e);
        }

    }

    public List<LoanResponseEntity> getAllLaons(){
        List<LoanResponseEntity> listEntity = new ArrayList<>();
        try {

            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("SELECT Loan.loan_id , Customer.name as customer_name, Loan_type.type_name, Branch.name as branch_name, Loan_status.status_name, Loan.principal_amount, Loan.intrest_rate, Loan.term_months, Loan.start_date, Loan.end_date  FROM Loan  JOIN Customer ON Loan.customer_id = Customer.cust_id JOIN Loan_type ON Loan.loan_type = Loan_type.loan_type_id JOIN Branch ON Loan.branch_id = Branch.branch_id JOIN Loan_status ON Loan.status_id = Loan_status.status_id order by loan_id ;");
            resultSet = pstmt.executeQuery();
            pstmt=null;
            while(resultSet.next()) {
                LoanResponseEntity responseEntity = new LoanResponseEntity();
                responseEntity.setLoanId(resultSet.getInt("loan_id"));
                responseEntity.setCustomerName(resultSet.getString("customer_name"));
                responseEntity.setLoanType(resultSet.getString("type_name"));
                responseEntity.setBranchType(resultSet.getString("branch_name"));
                responseEntity.setStatusName(resultSet.getString("status_name"));
                responseEntity.setPrincipalAmount(resultSet.getFloat("principal_amount"));
                responseEntity.setIntrestRate(resultSet.getFloat("intrest_rate"));
                responseEntity.setTermMonths(resultSet.getInt("term_months"));
                responseEntity.setStartDate(resultSet.getDate("start_date"));
                responseEntity.setEndDate(resultSet.getDate("end_date"));
                listEntity.add(responseEntity);
            }

            return listEntity;
        } catch (SQLException e) {
            throw new RuntimeException("Error adding branch", e);
        }

    }

    public LoanResponseEntity getLoan(Integer loanId){

        LoanResponseEntity responseEntity = new LoanResponseEntity();
        try {

            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("SELECT Loan.loan_id , Customer.name as customer_name, Loan_type.type_name, Branch.name as branch_name, Loan_status.status_name, Loan.principal_amount, Loan.intrest_rate, Loan.term_months, Loan.start_date, Loan.end_date  FROM Loan  JOIN Customer ON Loan.customer_id = Customer.cust_id JOIN Loan_type ON Loan.loan_type = Loan_type.loan_type_id JOIN Branch ON Loan.branch_id = Branch.branch_id JOIN Loan_status ON Loan.status_id = Loan_status.status_id where loan_id=?;");
            pstmt.setFloat(1,loanId);
            resultSet = pstmt.executeQuery();
            pstmt=null;
            while(resultSet.next()) {
                responseEntity.setLoanId(resultSet.getInt("loan_id"));
                responseEntity.setCustomerName(resultSet.getString("customer_name"));
                responseEntity.setLoanType(resultSet.getString("type_name"));
                responseEntity.setBranchType(resultSet.getString("branch_name"));
                responseEntity.setStatusName(resultSet.getString("status_name"));
                responseEntity.setPrincipalAmount(resultSet.getFloat("principal_amount"));
                responseEntity.setIntrestRate(resultSet.getFloat("intrest_rate"));
                responseEntity.setTermMonths(resultSet.getInt("term_months"));
                responseEntity.setStartDate(resultSet.getDate("start_date"));
                responseEntity.setEndDate(resultSet.getDate("end_date"));
            }

            return responseEntity;
        } catch (SQLException e) {
            throw new RuntimeException("Error adding branch", e);
        }

    }

    public String updateLoan(LoanEntity entity){

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update Loan set status_id=?, term_months=? , start_date=? , end_date=? where loan_id=?;");
            pstmt.setInt(1,entity.getStatusId());
            pstmt.setInt(2,entity.getTermMonths());
            pstmt.setDate(3,entity.getStartDate());
            pstmt.setDate(4,entity.getEndDate());
            pstmt.setInt(5,entity.getLoanId());
            int result = pstmt.executeUpdate();
            pstmt=null;
            return result + " row(s) Updated.";
        } catch (SQLException e) {
            throw new RuntimeException("Error Updating branch", e);
        }

    }

    public String deleteLoan(Integer id){

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("delete from Loan where loan_id=?");
            pstmt.setInt(1,id);
            int result = pstmt.executeUpdate();
            pstmt=null;
            return result + " row(s) Deleted.";
        } catch (SQLException e) {
            throw new RuntimeException("Error Updating branch", e);
        }

    }
    public String approveLoan(Integer loanId){

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("UPDATE Loan SET status_id = 3, start_date = CURRENT_DATE(), end_date = DATE_ADD(CURRENT_DATE(), INTERVAL term_months MONTH) WHERE loan_id = ?;");
            pstmt.setInt(1,loanId);
            int result = pstmt.executeUpdate();
            pstmt=null;
            return result + " Status Changed.";
        } catch (SQLException e) {
            throw new RuntimeException("Error Updating branch", e);
        }

    }
    }


