package com.jocata.studentmanagementsystem.controller;

import com.jocata.studentmanagementsystem.service.AssignCourseService;
import com.jocata.studentmanagementsystem.service.imp.AssignCourseServiceImp;

public class AssignCourseController {
    AssignCourseService service = new AssignCourseServiceImp();

    public String assignCourseToStudent(String courseId,String studenId){

        if(courseId!=null && !courseId.isEmpty()&&
                studenId!=null && !studenId.isEmpty()){
            return service.assignCourseToStudent(courseId,studenId);
        }
        return " Validation Not Satisfied";

    }

    public String updateCourseToStudent(String courseId, String studentId){

        if(courseId!=null && !courseId.isEmpty()&&
                studentId!=null && !studentId.isEmpty()){
             return service.updateCourseToStudent(courseId,studentId);
        }
        return " Validation Not Satisfied";

    }
    public String deleteCourseToStudent(String studentId){
        if(studentId!=null&& !studentId.isEmpty()){
           return  service.deleteCourseToStudent(studentId);
        }
        return " Validation Not Satisfied";
    }
}
