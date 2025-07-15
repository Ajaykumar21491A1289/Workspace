package com.jocata.studentmanagementsystem.Main;

import com.jocata.studentmanagementsystem.controller.AttendanceController;
import com.jocata.studentmanagementsystem.form.AttendanceForm;

public class AttendanceMain {
    public static void main(String[] args){
        AttendanceController controller = new AttendanceController();
        AttendanceForm form = new AttendanceForm();
        form.setAttendanceId("410");
        form.setStudentId("302");
        form.setSubjectId("210");
        form.setStatus("Present");
        System.out.println(controller.markAttendance(form));

    }
}
