package com.jocata;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pojo {
@Id
    private int sid;
    private String name;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                '}';
    }
}
