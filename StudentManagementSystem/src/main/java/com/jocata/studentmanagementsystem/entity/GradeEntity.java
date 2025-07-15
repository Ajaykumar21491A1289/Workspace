package com.jocata.studentmanagementsystem.entity;

public class GradeEntity {

    private Integer gradeId;
    private Integer studentId;
    private Integer subjectId;
    private String grade;

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(String gradeId) {
        this.gradeId =Integer.parseInt(gradeId);
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = Integer.parseInt(studentId);
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = Integer.parseInt( subjectId);
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
