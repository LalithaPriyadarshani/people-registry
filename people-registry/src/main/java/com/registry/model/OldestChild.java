package com.registry.model;

import java.io.Serializable;

public class OldestChild implements Serializable {

    private String childName;
    private long personalNum;

    public String getChildName() {
        return childName;
    }

    public void setChildName(String childName) {
        this.childName = childName;
    }

    public long getPersonalNum() {
        return personalNum;
    }

    public void setPersonalNum(long personalNum) {
        this.personalNum = personalNum;
    }
}
