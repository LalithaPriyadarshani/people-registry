package com.registry.model;

public class Person implements Serializable{

    private long personalNumber;
    private String fname;

    private String lname;

    private String spouseName;

    private List<Child> children;
}
