package jocata.student.service;
import java.util.*;
public class Student extends AbstractPerson {
    private String section;
    private String category;
    List<String> skills ;

    public Student(String name, String id, int age, String dept, String section, String category,List<String> l) {
        super(name, id, age, dept);
        this.section = section;
        this.category = category;
        this.skills =l;
    }

    public void displayDetails() {
        super.displayDetails();
        System.out.println("Section: " + section);
        System.out.println("Category: " + category);
        System.out.print("Skills : ");
        for (String skill : skills) {
            System.out.print(skill + " ");
        }
    }
}
