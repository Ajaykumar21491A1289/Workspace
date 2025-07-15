package com.jocata.studentmanagementsystem.dao.imp;

import com.jocata.studentmanagementsystem.dao.AssignCourseDao;
import com.jocata.studentmanagementsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AssignCourseDaoImp implements AssignCourseDao {

    Connection conn;
    PreparedStatement pstmt;
    public String assignCourseToStudent(String courseId,String studenId){

        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("insert into student_course values(?,?);");
            pstmt.setInt(1,Integer.parseInt(studenId));
            pstmt.setInt(2,Integer.parseInt(courseId));
            Integer res = pstmt.executeUpdate();
            return res + " rows Inserted";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }

    }
    public String updateCourseToStudent(String courseId, String studentId){
        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("update student_course set course_id=? where student_id=?;");
            pstmt.setInt(2,Integer.parseInt(studentId));
            pstmt.setInt(1,Integer.parseInt(courseId));
            Integer res = pstmt.executeUpdate();
            return res + " rows Updated";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }
    }
    public String deleteCourseToStudent(String studentId){
        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("delete from student_course where student_id=?;");
            pstmt.setInt(1,Integer.parseInt(studentId));
            Integer res = pstmt.executeUpdate();
            return res + " rows deleted";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }
    }
}
