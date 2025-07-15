package com.jocata.studentmanagementsystem.dao;

import com.jocata.studentmanagementsystem.entity.AttendanceEntity;
import com.jocata.studentmanagementsystem.form.AttendanceForm;

public interface AttendanceDao {
    String markAttendance(AttendanceEntity form);
    public String updateAttendance(AttendanceEntity entity);
    public String deleteAttendance(String studentId);
}
