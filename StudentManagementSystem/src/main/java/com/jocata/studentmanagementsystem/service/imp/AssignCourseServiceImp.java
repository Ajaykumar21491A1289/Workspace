package com.jocata.studentmanagementsystem.service.imp;

import com.jocata.studentmanagementsystem.dao.AssignCourseDao;
import com.jocata.studentmanagementsystem.dao.imp.AssignCourseDaoImp;
import com.jocata.studentmanagementsystem.service.AssignCourseService;

public class AssignCourseServiceImp implements AssignCourseService {
    AssignCourseDao dao = new AssignCourseDaoImp();

    public String assignCourseToStudent(String courseId,String studenId){
        return dao.assignCourseToStudent(courseId,studenId);

    }
    public String updateCourseToStudent(String courseId, String studentId){
        return dao.updateCourseToStudent(courseId,studentId);

    }
    public String deleteCourseToStudent(String studentId){
        return dao.deleteCourseToStudent(studentId);
    }
}
