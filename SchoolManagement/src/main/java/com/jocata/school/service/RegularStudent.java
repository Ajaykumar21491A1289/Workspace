package com.jocata.school.service;

public class RegularStudent extends Student{
    public RegularStudent(String name,String email,Integer rollNo,String grade){
        super(name,email,rollNo,grade);
    }

    public void displayTypeOfStudent(){
        System.out.println("He is a Regular Student");
        System.out.println("----------");

    }
}
