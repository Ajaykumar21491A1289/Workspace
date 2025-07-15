package com.jocata.studentmanagementsystem.controller;

import com.jocata.studentmanagementsystem.form.GradeForm;
import com.jocata.studentmanagementsystem.service.GradeService;
import com.jocata.studentmanagementsystem.service.imp.GradeServiceImp;

public class GradeController {
    GradeService service = new GradeServiceImp();

    public String addGrade(GradeForm form){
        if(form.getGradeId()!=null && !form.getGradeId().isEmpty() &&
        form.getStudentId()!=null && !form.getStudentId().isEmpty() &&
        form.getSubjectId()!=null && !form.getSubjectId().isEmpty()&&
        form.getGrade()!=null && !form.getGrade().isEmpty()){
           return service.addGrade(form);
        }
        return " Validation Not Satisfied";
    }

    public String updateGrade(GradeForm form){
        if(form.getGradeId()!=null && !form.getGradeId().isEmpty() &&
                form.getStudentId()!=null && !form.getStudentId().isEmpty() &&
                form.getSubjectId()!=null && !form.getSubjectId().isEmpty()&&
                form.getGrade()!=null && !form.getGrade().isEmpty()){
            return service.updateGrade(form);
        }
        return " Validation Not Satisfied";
    }
    public String deleteGrade(String studentId){
        if(studentId!=null && !studentId.isEmpty()){
            return service.deleteGrade(studentId);
        }
        return " Validation Not Satisfied";
    }

    public void getGradeSubjectWise(String subjectId){

    }
}
