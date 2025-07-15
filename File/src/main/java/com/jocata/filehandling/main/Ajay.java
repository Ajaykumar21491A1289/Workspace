package com.jocata.filehandling.main;

import java.io.Serializable;

public class Ajay implements Serializable {

    private String name;
    private Integer Age;
    private final long serialVersionUID = 1L;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(Integer age) {
        Age = age;
    }
}
