package com.jocata.studentmanagementsystem.dao;

import com.jocata.studentmanagementsystem.entity.GradeEntity;
import com.jocata.studentmanagementsystem.form.GradeForm;

public interface GradeDao {
    public String addGrade(GradeEntity entity);
    String updateGrade(GradeEntity form);
    public String deleteGrade(String studentId);
}
