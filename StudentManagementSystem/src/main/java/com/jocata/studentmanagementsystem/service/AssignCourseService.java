package com.jocata.studentmanagementsystem.service;

public interface AssignCourseService {

    String assignCourseToStudent(String courseId,String studenId);
    String updateCourseToStudent(String courseId, String studentId);
    String deleteCourseToStudent(String studentId);
}
