package com.jocata.school.service;

import java.util.*;

public class School {

   // private List<Student> students = new ArrayList<Student>();

    public void assignCourseToStudent(Student student, Course course) {
        student.setCourse(course);
       // students.add(student);
    }

    public void updateGrade(Student student, String newGrade) {
        student.setGrade(newGrade);
    }

    public void showAllStudents(Student student) {
        /*for (Student s : students) {
            s.displayInformation();
            s.displayTypeOfStudent();
        }*/
        student.displayInformation();
        student.displayTypeOfStudent();



    }
}
