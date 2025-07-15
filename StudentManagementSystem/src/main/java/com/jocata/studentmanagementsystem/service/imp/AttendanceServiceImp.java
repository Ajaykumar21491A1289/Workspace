package com.jocata.studentmanagementsystem.service.imp;

import com.jocata.studentmanagementsystem.dao.AttendanceDao;
import com.jocata.studentmanagementsystem.dao.imp.AttendanceDaoImp;
import com.jocata.studentmanagementsystem.entity.AttendanceEntity;
import com.jocata.studentmanagementsystem.form.AttendanceForm;
import com.jocata.studentmanagementsystem.service.AttendanceService;

public class AttendanceServiceImp implements AttendanceService {

    AttendanceDao dao = new AttendanceDaoImp();

    public String markAttendance(AttendanceForm form){
        AttendanceEntity entity = new AttendanceEntity();
        entity.setAttendanceId(form.getAttendanceId());
        entity.setStudentId(form.getStudentId());
        entity.setSubjectId(form.getSubjectId());
        entity.setStatus(form.getStatus());
        return dao.markAttendance(entity);

    }

    public String updateAttendance(AttendanceForm form){
        AttendanceEntity entity = new AttendanceEntity();
        entity.setAttendanceId(form.getAttendanceId());
        entity.setStudentId(form.getStudentId());
        entity.setSubjectId(form.getSubjectId());
        entity.setStatus(form.getStatus());
        return dao.updateAttendance(entity);
    }
    public String deleteAttendance(String studentId){
        return dao.deleteAttendance(studentId);
    }
}
