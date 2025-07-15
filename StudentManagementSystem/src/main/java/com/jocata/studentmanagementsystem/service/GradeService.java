package com.jocata.studentmanagementsystem.service;

import com.jocata.studentmanagementsystem.form.GradeForm;

public interface GradeService {
    String addGrade(GradeForm form);
    String updateGrade(GradeForm form);
    public String deleteGrade(String studentId);
}
