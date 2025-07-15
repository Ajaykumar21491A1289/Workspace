package com.jocata.studentmanagementsystem.service;

import com.jocata.studentmanagementsystem.entity.StudentResponse;
import com.jocata.studentmanagementsystem.form.GradeTrackForm;
import com.jocata.studentmanagementsystem.form.GroupStudentForm;
import com.jocata.studentmanagementsystem.form.StudentForm;

import java.util.List;
import java.util.Map;

public interface StudentService {

    String addStudent(StudentForm form);
    String updateStudent(StudentForm form);
    String removeStudent(String id);
    List<StudentResponse> getStudents();
    Map<String, List<GroupStudentForm>> groupStudents();
    Map<String, List<GradeTrackForm>> trackGradeSubjectWise();

}
