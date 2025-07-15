package com.jocata.school.service;

public class PartTimeStudent extends Student{
    public PartTimeStudent(String name,String email,Integer rollNo,String grade){
        super(name,email,rollNo,grade);
    }

    public void displayTypeOfStudent(){
        System.out.println("He is a PartTime Student");
        System.out.println("-------------------");

    }
}
