package com.jocata.studentmanagementsystem.dao;

import com.jocata.studentmanagementsystem.entity.StudentEntity;
import com.jocata.studentmanagementsystem.entity.StudentResponse;

import java.util.List;


public interface StudentDao {

    String addStudent(StudentEntity form);
    String updateStudent(StudentEntity form);
    String removeStudent(String id);
    public List<StudentResponse> getStudents();


}
