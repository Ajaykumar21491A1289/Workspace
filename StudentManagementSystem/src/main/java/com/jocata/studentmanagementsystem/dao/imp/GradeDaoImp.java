package com.jocata.studentmanagementsystem.dao.imp;

import com.jocata.studentmanagementsystem.dao.GradeDao;
import com.jocata.studentmanagementsystem.entity.GradeEntity;
import com.jocata.studentmanagementsystem.form.GradeForm;
import com.jocata.studentmanagementsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GradeDaoImp implements GradeDao {

    Connection conn;
    PreparedStatement pstmt;

    public String addGrade(GradeEntity entity){
        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("insert into Grade values(?,?,?,?);");
            pstmt.setInt(1,entity.getGradeId());
            pstmt.setInt(2,entity.getStudentId());
            pstmt.setInt(3,entity.getSubjectId());
            pstmt.setString(4,entity.getGrade());

            Integer res = pstmt.executeUpdate();
            return res + "Grade Marked";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }

    }
    public String updateGrade(GradeEntity entity){

        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("update Grade set student_id=?,subject_id=?,grade=? where grade_id=?;");
            pstmt.setInt(4,entity.getGradeId());
            pstmt.setInt(1,entity.getStudentId());
            pstmt.setInt(2,entity.getSubjectId());
            pstmt.setString(3,entity.getGrade());

            Integer res = pstmt.executeUpdate();
            return res + "Grade Updated";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }

    }

    public String deleteGrade(String studentId){
        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("delete from Grade where student_id=?;");
            pstmt.setInt(1,Integer.parseInt(studentId));

            Integer res = pstmt.executeUpdate();
            return res + "Grade Deleted";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }
    }
}
