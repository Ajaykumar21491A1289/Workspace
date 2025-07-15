package jocata.student.service;

abstract class AbstractPerson implements Person {
    private String name;
    private String id;
    private Integer age;
    private String dept;

    public AbstractPerson(String name, String id, Integer age, String dept) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.dept = dept;
    }


    public void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Age: " + age);
        System.out.println("Dept: " + dept);
    }

}
