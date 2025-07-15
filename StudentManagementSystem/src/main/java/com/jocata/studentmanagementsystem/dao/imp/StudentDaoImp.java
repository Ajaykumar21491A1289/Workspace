package com.jocata.studentmanagementsystem.dao.imp;

import com.jocata.studentmanagementsystem.dao.StudentDao;
import com.jocata.studentmanagementsystem.entity.StudentEntity;
import com.jocata.studentmanagementsystem.entity.StudentResponse;
import com.jocata.studentmanagementsystem.form.StudentForm;
import com.jocata.studentmanagementsystem.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImp implements StudentDao {

    Connection conn;
    PreparedStatement pstmt;

    public String addStudent(StudentEntity entity) {

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("insert into Student values(?,?,?,?,?,?);");
            pstmt.setInt(1, entity.getStudentId());
            pstmt.setString(2, entity.getStudentName());
            pstmt.setString(3, entity.getEmail());
            pstmt.setLong(4, entity.getPhone());
            pstmt.setString(5, entity.getAddress());
            pstmt.setDate(6, entity.getDob());
            Integer res = pstmt.executeUpdate();
            return res + " rows Inserted";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }


    }

    public String updateStudent(StudentEntity entity) {

        try {
            conn = DBConnection.getConnection();
            pstmt = conn.prepareStatement("update Student set student_name=?,email=?,phone=?,address=?,date_of_birth=? where student_id=?");
            pstmt.setInt(6, entity.getStudentId());
            pstmt.setString(1, entity.getStudentName());
            pstmt.setString(2, entity.getEmail());
            pstmt.setLong(3, entity.getPhone());
            pstmt.setString(4, entity.getAddress());
            pstmt.setDate(5, entity.getDob());
            Integer res = pstmt.executeUpdate();
            return res + " rows Updated";


        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving customers", e);
        }


    }

    public String removeStudent(String id) {

        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("delete from student where student_id=?;");
            pstmt.setInt(1, Integer.parseInt(id));
            Integer res = pstmt.executeUpdate();
            return res + " rows Deleted";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<StudentResponse> getStudents() {
        List<StudentResponse> list = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();

            pstmt = conn.prepareStatement("select s.student_id,s.student_name,s.email,s.phone,s.address,s.date_of_birth, c.course_name,su.subject_name, g.grade, a.status  from Student_Course sc join Course c  on sc.course_id = c.course_id join Student s on sc.student_id=s.student_id join Student_subjects ss on s.student_id=ss.student_id join subject su on ss.subject_id=su.subject_id join Grade g on g.student_id=s.student_id AND g.subject_id= su.subject_id join Attendance a on a.student_id=s.student_id AND a.subject_id = su.subject_id;");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                StudentResponse response = new StudentResponse();
                response.setStudentId(rs.getInt("student_id"));
                response.setName(rs.getString("student_name"));
                response.setEmail(rs.getString("email"));
                response.setPhone(rs.getLong("phone"));
                response.setAddress(rs.getString("address"));
                response.setDob(rs.getDate("date_of_birth"));
                response.setCourseName(rs.getString("course_name"));
                response.setSubjectName(rs.getString("subject_name"));
                response.setGrade(rs.getString("grade"));
                response.setStatus(rs.getString("status"));
                list.add(response);

            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}



