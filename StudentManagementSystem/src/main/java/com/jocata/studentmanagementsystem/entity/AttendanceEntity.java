package com.jocata.studentmanagementsystem.entity;

import java.sql.Date;

public class AttendanceEntity {

    private Integer attendanceId;
    private Integer studentId;
    private Integer subjectId;
    private String status;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = Date.valueOf(date);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = Integer.parseInt(attendanceId);
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId =Integer.parseInt( studentId);
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = Integer.parseInt(subjectId);
    }
}
