package com.jocata.studentmanagementsystem.controller;

import com.jocata.studentmanagementsystem.form.AttendanceForm;
import com.jocata.studentmanagementsystem.service.AttendanceService;
import com.jocata.studentmanagementsystem.service.imp.AttendanceServiceImp;

public class AttendanceController {
    AttendanceService service = new AttendanceServiceImp();

    public String markAttendance(AttendanceForm form){
        if(form.getAttendanceId()!=null && !form.getAttendanceId().isEmpty() &&
        form.getStudentId()!=null && !form.getStudentId().isEmpty() &&
        form.getSubjectId()!=null && !form.getSubjectId().isEmpty() &&
        form.getStatus()!=null && !form.getStatus().isEmpty() ){

           return  service.markAttendance(form);
        }
        return "Validation Not Satisfied";
    }

    public String updateAttendance(AttendanceForm form){
        if(form.getAttendanceId()!=null && !form.getAttendanceId().isEmpty() &&
                form.getStudentId()!=null && !form.getStudentId().isEmpty() &&
                form.getSubjectId()!=null && !form.getSubjectId().isEmpty() &&
                form.getStatus()!=null && !form.getStatus().isEmpty()){

            return  service.updateAttendance(form);
        }
        return "Validation Not Satisfied";
    }
    public String deleteAttendance(String studentId){
        if(studentId!=null && !studentId.isEmpty()){
           return  service.deleteAttendance(studentId);
        }
        return "Validation Not Satisfied";
    }
}
