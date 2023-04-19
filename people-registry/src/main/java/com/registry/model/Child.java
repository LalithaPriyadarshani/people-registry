package com.registry.model;

import java.io.Serializable;

public class Child implements Serializable,Comparable {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public int compareTo(Object o) {

            int compareage=((Child)o).getAge();
            /* For Ascending order*/
            return compareage-this.age;


        }

}
