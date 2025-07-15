package com.bankingsystem.dao.imp;

import com.bankingsystem.dao.LoanPaymentDao;
import com.bankingsystem.entity.LoanPaymentEntity;
import com.bankingsystem.util.DBConnection;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoanPaymentDaoImp implements LoanPaymentDao {

    Connection conn;
    PreparedStatement pstmt;

    public String addLaonPayment(LoanPaymentEntity entity) {
        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("insert into Loan_payment(loan_id,payment_date,amount_paid,principal_component,intrest_component) values(?,CURRENT_DATE(),?,?,?);");
            pstmt.setInt(1, entity.getLoanID());
            pstmt.setFloat(2, entity.getAmountPaid());
            pstmt.setFloat(3, entity.getPrincipalComponent());
            pstmt.setFloat(4, entity.getIntrestComponent());

            Integer res = pstmt.executeUpdate();
            return res + " rows Inserted";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }


    }

    public String updateLoanPayment(LoanPaymentEntity entity) {

        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("update Laon_payment set loan_id = ?, payment_date=?, amount_paid=?, principal_component=?,intrest_component=? where payment_id=?;");
            pstmt.setInt(1, entity.getLoanID());
            pstmt.setDate(2, entity.getPaymentDate());
            pstmt.setFloat(3, entity.getAmountPaid());
            pstmt.setFloat(4, entity.getPrincipalComponent());
            pstmt.setFloat(5, entity.getIntrestComponent());
            pstmt.setInt(6, entity.getLoanID());

            Integer res = pstmt.executeUpdate();
            return res + " rows Updated";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }


    }

    public File getLaonPayment(Integer loanId) {
        File file = new File("D:\\Jocata_Internship\\JAVA\\Loan" + loanId + ".txt");
        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("SELECT * FROM Loan_payment where loan_id = ?");
            pstmt.setInt(1, loanId);
            ResultSet rs = pstmt.executeQuery();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            String header = String.format("| %-11s | %-7s | %-12s | %-11s | %-19s | %-17s |", "payment_id", "loan_id", "payment_date", "amount_paid", "principal_component", "intrest_component");
            writer.write(header);
            writer.newLine();
            writer.write("|-------------|---------|--------------|-------------|---------------------|-------------------|");
            while (rs.next()) {
                String row = String.format("| %-11d | %-7d | %-12s | %-11.2f | %-19.2f | %-17.2f |",
                        rs.getInt("payment_id"),
                        rs.getInt("loan_id"),
                        rs.getDate("payment_date").toString(),
                        rs.getFloat("amount_paid"),
                        rs.getFloat("principal_component"),
                        rs.getFloat("intrest_component"));
                writer.newLine();
                writer.write(row);
            }
            writer.close();
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        return file;


    }

    public Path getAllLaonPayment() {
        Path path = Paths.get("D:\\Jocata_Internship\\JAVA\\payments.txt");

        try {
            if (!Files.exists(path)) {
                Files.createFile(path);

            }
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("SELECT * FROM Loan_payment;");
            ResultSet rs = pstmt.executeQuery();
            //ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("D:\\Jocata_Internship\\JAVA\\payments.txt"));

            while (rs.next()) {
                LoanPaymentEntity entity = new LoanPaymentEntity();
                entity.setPaymentId(String.valueOf(rs.getInt("payment_id")));
                entity.setLoanID(String.valueOf(rs.getInt("loan_id")));
                entity.setPaymentDate(String.valueOf(rs.getDate("payment_date")));
                entity.setAmountPaid(String.valueOf(rs.getFloat("amount_paid")));
                entity.setPrincipalComponent(String.valueOf(rs.getFloat("principal_component")));
                entity.setIntrestComponent(String.valueOf(rs.getFloat("intrest_component")));
                //writer.writeObject(entity);

                Files.write(path, List.of("PaymentId: " + entity.getPaymentId() + "  " + "Laon Id: " + entity.getLoanID() + "  " + "Payment Date: " + entity.getPaymentDate() + "  " + "Amount Paid:  " + entity.getAmountPaid() + "  " + "Principal Component: " + entity.getPrincipalComponent() + "  " + "Intrest Component " + entity.getIntrestComponent()), StandardOpenOption.APPEND);
            }

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }

        return path;


    }

    public String deleteLaon(Integer loanId) {

        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("DELETE FROM Loan_payment WHERE payment_id = ?");

            pstmt.setInt(1, loanId);
            int res = pstmt.executeUpdate();
            return res + " row(s) deleted";

        } catch (SQLException e) {
            throw new RuntimeException("Error deleting customer", e);
        }
    }

    @Override
    public int getPaymentCountForLoan(int loanId) {
        int count = 0;
        try {
            conn = DBConnection.getConnection(); // Use DBConnection instead of DBUtil
            pstmt = conn.prepareStatement("SELECT COUNT(*) FROM Loan_payment WHERE loan_id = ?");
            pstmt.setInt(1, loanId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return count;
    }


}

