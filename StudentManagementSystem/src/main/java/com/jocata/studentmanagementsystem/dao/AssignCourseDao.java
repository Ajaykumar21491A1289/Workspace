package com.jocata.studentmanagementsystem.dao;

public interface AssignCourseDao {
    String assignCourseToStudent(String courseId,String studenId);
    String updateCourseToStudent(String courseId, String studentId);
    String deleteCourseToStudent(String studentId);

}
