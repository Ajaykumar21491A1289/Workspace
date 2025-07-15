package com.jocata.studentmanagementsystem.controller;

import com.jocata.studentmanagementsystem.entity.StudentResponse;
import com.jocata.studentmanagementsystem.form.GradeTrackForm;
import com.jocata.studentmanagementsystem.form.GroupStudentForm;
import com.jocata.studentmanagementsystem.form.StudentForm;
import com.jocata.studentmanagementsystem.service.StudentService;
import com.jocata.studentmanagementsystem.service.imp.StudentServiceImp;

import java.util.List;
import java.util.Map;

public class StudentController {

    StudentService service = new StudentServiceImp();

    public String addStudent(StudentForm form) {
        if (form.getStudentId() != null && !form.getStudentId().isEmpty() &&
                form.getStudentName() != null && !form.getStudentName().isEmpty() &&
                form.getEmail() != null && !form.getEmail().isEmpty() &&
                form.getPhone() != null && !form.getPhone().isEmpty() &&
                form.getAddress() != null && !form.getAddress().isEmpty() &&
                form.getDob() != null && !form.getDob().isEmpty()) {
            return service.addStudent(form);
        }

        return " Validation Not Satisfied";

    }

    public String updateStudent(StudentForm form) {
        if (form.getStudentId() != null && !form.getStudentId().isEmpty() &&
                form.getStudentName() != null && !form.getStudentName().isEmpty() &&
                form.getEmail() != null && !form.getEmail().isEmpty() &&
                form.getPhone() != null && !form.getPhone().isEmpty() &&
                form.getAddress() != null && !form.getAddress().isEmpty() &&
                form.getDob() != null && !form.getDob().isEmpty()) {
            return service.updateStudent(form);
        }

        return " Validation Not Satisfied";

    }


    public String removeStudent(String id) {
        if (id != null && !id.isEmpty()) {
            return service.removeStudent(id);
        }
        return "Validation Not Satisfied";
    }

    public List<StudentResponse> getStudents() {

        return service.getStudents();


    }

    public Map<String, List<GroupStudentForm>> groupStudents(){

        return service.groupStudents();

    }

    public Map<String, List<GradeTrackForm>> trackGradeSubjectWise(){
        return service.trackGradeSubjectWise();
    }


}
