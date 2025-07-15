package com.jocata.studentmanagementsystem.dao.imp;

import com.jocata.studentmanagementsystem.dao.AttendanceDao;
import com.jocata.studentmanagementsystem.entity.AttendanceEntity;
import com.jocata.studentmanagementsystem.form.AttendanceForm;
import com.jocata.studentmanagementsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AttendanceDaoImp implements AttendanceDao {
    Connection conn;
    PreparedStatement pstmt;

    public String markAttendance(AttendanceEntity entity){
        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("insert into Attendance values(?,?,?,?,current_date());");
            pstmt.setInt(1,entity.getAttendanceId());
            pstmt.setInt(2,entity.getStudentId());
            pstmt.setInt(3,entity.getSubjectId());
            pstmt.setString(4,entity.getStatus());
            Integer res = pstmt.executeUpdate();
            return res + "Attendance Marked";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }

    }

    public String updateAttendance(AttendanceEntity entity){

        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("update Attendance set student_id=?,subject_id=?,status=? where attendance_id=?;");
            pstmt.setInt(4,entity.getAttendanceId());
            pstmt.setInt(1,entity.getStudentId());
            pstmt.setInt(2,entity.getSubjectId());
            pstmt.setString(3,entity.getStatus());
            Integer res = pstmt.executeUpdate();
            return res + "Attendance Updated";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }


    }
    public String deleteAttendance(String studentId){
        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("delete from Attendance where student_id=?;");
            pstmt.setInt(1,Integer.parseInt(studentId));
            Integer res = pstmt.executeUpdate();
            return res + "Attendance Updated";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }
    }
}
