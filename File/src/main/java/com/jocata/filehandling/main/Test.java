package com.jocata.filehandling.main;

import java.io.Serializable;

public class Test implements Serializable {

    Integer id;
    String name;

    public Test(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
