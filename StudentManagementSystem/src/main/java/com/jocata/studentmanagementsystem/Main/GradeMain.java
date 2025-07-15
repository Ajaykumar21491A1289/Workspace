package com.jocata.studentmanagementsystem.Main;

import com.jocata.studentmanagementsystem.controller.GradeController;
import com.jocata.studentmanagementsystem.form.GradeForm;

public class GradeMain {
    public static void main(String[] args){
        GradeController controller = new GradeController();
        GradeForm form = new GradeForm();
        form.setGradeId("510");
        form.setStudentId("302");
        form.setSubjectId("210");
        form.setGrade("B");
        System.out.println(controller.addGrade(form));
        //System.out.println(controller.deleteGrade("301"));
    }
}
