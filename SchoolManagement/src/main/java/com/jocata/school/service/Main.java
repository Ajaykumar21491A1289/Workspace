package com.jocata.school.service;

import java.util.ArrayList;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Course course1 = new Course("Java");
        Course course2 = new Course("c");

        Student student1 = new RegularStudent("ajay","ajju@123",123,"A");
        Student student2 = new PartTimeStudent("Kumar","Kumar@123",456,"A+");

        School school = new School();
        school.assignCourseToStudent(student1,course1);
        school.assignCourseToStudent(student2,course2);

        school.showAllStudents(student1);

        school.updateGrade(student1,"B");



        school.showAllStudents(student1);



    }
}