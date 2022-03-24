package com.example.tcrs;

public class Profile {
    //type indicate the type of this user(1 for admin, 2 for officer, 3 for driver)
    int type = -1;
    //id is a unique string of number to represent the current user
    String id = null;

    //constructor
    public Profile(){}

    //getters and setters
    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
