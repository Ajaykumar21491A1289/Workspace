package com.jocata.studentmanagementsystem.service;

import com.jocata.studentmanagementsystem.form.AttendanceForm;

public interface AttendanceService {

    String markAttendance(AttendanceForm form);
    String updateAttendance(AttendanceForm form);
    public String deleteAttendance(String studentId);
}
