package jocata.student.service;

public class Teacher extends AbstractPerson{
    private String designation;
    private double salary;

    public Teacher(String name, String id, int age, String dept, String designation, double salary) {
        super(name, id, age, dept);
        this.designation = designation;
        this.salary = salary;
    }
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Designation : " + designation);
        System.out.println("Salary: "+ salary);

    }
}
