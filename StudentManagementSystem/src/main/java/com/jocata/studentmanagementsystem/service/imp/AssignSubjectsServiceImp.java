package com.jocata.studentmanagementsystem.service.imp;

import com.jocata.studentmanagementsystem.dao.AssignSubjectsDao;
import com.jocata.studentmanagementsystem.dao.imp.AssignSubjectsDaoImp;
import com.jocata.studentmanagementsystem.service.AssignSubjectsService;

public class AssignSubjectsServiceImp implements AssignSubjectsService {
    AssignSubjectsDao dao = new AssignSubjectsDaoImp();

    public String assignSubjectsToStudent(String studentId,String subjectId){
        return  dao.assignSubjectsToStudent(studentId,subjectId);

    }

    public String updateSubjectsToStudent(String studentId,String subjectId){
        return dao.updateSubjectsToStudent(studentId,subjectId);
    }
    public String deleteSubjectsToStudent(String studentId){
        return dao.deleteSubjectsToStudent(studentId);
    }

}
