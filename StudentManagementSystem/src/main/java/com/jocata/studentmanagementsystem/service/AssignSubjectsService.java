package com.jocata.studentmanagementsystem.service;

public interface AssignSubjectsService {

    String assignSubjectsToStudent(String studentId,String subjectId);
    String updateSubjectsToStudent(String studentId,String subjectId);
    String deleteSubjectsToStudent(String studentId);
}
