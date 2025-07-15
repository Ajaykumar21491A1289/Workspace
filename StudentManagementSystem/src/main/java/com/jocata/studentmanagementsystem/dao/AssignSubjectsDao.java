package com.jocata.studentmanagementsystem.dao;

public interface AssignSubjectsDao {

    String assignSubjectsToStudent(String studentId,String subjectId);
    public String updateSubjectsToStudent(String studentId,String subjectId);
    public String deleteSubjectsToStudent(String studentId);
}
