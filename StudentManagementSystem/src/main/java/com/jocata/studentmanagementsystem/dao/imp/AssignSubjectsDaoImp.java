package com.jocata.studentmanagementsystem.dao.imp;

import com.jocata.studentmanagementsystem.dao.AssignSubjectsDao;
import com.jocata.studentmanagementsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AssignSubjectsDaoImp implements AssignSubjectsDao {

    Connection conn;
    PreparedStatement pstmt;

    public String assignSubjectsToStudent(String studentId,String subjectId){
        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("insert into student_subjects values(?,?);");
            pstmt.setInt(1,Integer.parseInt(studentId));
            pstmt.setInt(2,Integer.parseInt(subjectId));
            Integer res = pstmt.executeUpdate();
            return res + " rows Inserted";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }

    }
    public String updateSubjectsToStudent(String studentId,String subjectId){
        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("update student_subjects set subjectId=? where student_id=?;");
            pstmt.setInt(2,Integer.parseInt(studentId));
            pstmt.setInt(1,Integer.parseInt(subjectId));
            Integer res = pstmt.executeUpdate();
            return res + " rows Inserted";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }
    }

    public String deleteSubjectsToStudent(String studentId){
        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("delete from student_subjects where student_id=?;");
            pstmt.setInt(1,Integer.parseInt(studentId));
            Integer res = pstmt.executeUpdate();
            return res + " rows Inserted";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }
    }

}
