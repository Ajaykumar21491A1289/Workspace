package com.jocata.studentmanagementsystem.service.imp;

import com.jocata.studentmanagementsystem.dao.GradeDao;
import com.jocata.studentmanagementsystem.dao.imp.GradeDaoImp;
import com.jocata.studentmanagementsystem.entity.GradeEntity;
import com.jocata.studentmanagementsystem.form.GradeForm;
import com.jocata.studentmanagementsystem.service.GradeService;

public class GradeServiceImp implements GradeService {

    GradeDao dao = new GradeDaoImp();

    public String addGrade(GradeForm form){
        GradeEntity entity = new GradeEntity();
        entity.setGradeId(form.getGradeId());
        entity.setStudentId(form.getStudentId());
        entity.setSubjectId(form.getSubjectId());
        entity.setGrade(form.getGrade());
        return dao.addGrade(entity);

    }
    public String updateGrade(GradeForm form){
        GradeEntity entity = new GradeEntity();
        entity.setGradeId(form.getGradeId());
        entity.setStudentId(form.getStudentId());
        entity.setSubjectId(form.getSubjectId());
        entity.setGrade(form.getGrade());
        return dao.updateGrade(entity);
    }
    public String deleteGrade(String studentId){
        return dao.deleteGrade(studentId);
    }
}
