package com.jocata.school.service;

abstract class Student extends Person {

    private Integer rollNo;
    private String grade;
    private Course course;

    public Student(String name, String email, Integer rollNo, String grade) {
        super(name,email);
        this.rollNo = rollNo;
        this.grade = grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setCourse(Course course) {
        this.course = course;
    }



    public void displayInformation() {
        boolean flag = true;
        if(flag){
            throw new RuntimeException("flag is true");
        }
        System.out.println("Student Name is " + getName());
        System.out.println("Student Email is " + getEmail());
        System.out.println("Student Rollno is " + rollNo);
        System.out.println("Student grade is " + grade);
        System.out.println("Student course is" + course);

    }

    abstract void displayTypeOfStudent();


}
