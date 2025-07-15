package jocata.student.service;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person student = new Student("Ajay","7086",21,"IT","IT-A","General",new ArrayList<>(List.of("Java","python","c")));
        Person teacher = new Teacher("Dr.Prasad","T501",45,"CSE","Associate Professor",8500000);
        student.displayDetails();
        System.out.println();
        System.out.println("Professor Details Are");
        teacher.displayDetails();

    }
}