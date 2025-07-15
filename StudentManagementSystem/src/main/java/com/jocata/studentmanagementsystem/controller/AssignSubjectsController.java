package com.jocata.studentmanagementsystem.controller;

import com.jocata.studentmanagementsystem.service.AssignSubjectsService;
import com.jocata.studentmanagementsystem.service.imp.AssignSubjectsServiceImp;

public class AssignSubjectsController {

    AssignSubjectsService service = new AssignSubjectsServiceImp();

    public String assignSubjectsToStudent(String studentId,String subjectId){
        if(studentId!=null && !studentId.isEmpty() &&
                subjectId!=null && !subjectId.isEmpty()){
            return service.assignSubjectsToStudent(studentId,subjectId);

        }
        return " Validation Not Satisfied";

    }
    public String updateSubjectsToStudent(String studentId,String subjectId){
        if(studentId!=null && !studentId.isEmpty() &&
                subjectId!=null && !subjectId.isEmpty()){
            return service.updateSubjectsToStudent(studentId,subjectId);

        }
        return " Validation Not Satisfied";

    }

    public String deleteSubjectsToStudent(String studentId){
        if(studentId!=null && !studentId.isEmpty()){
            return service.deleteSubjectsToStudent(studentId);

        }
        return " Validation Not Satisfied";

    }



}
