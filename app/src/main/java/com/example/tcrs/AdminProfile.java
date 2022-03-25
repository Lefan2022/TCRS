package com.example.tcrs;

public class AdminProfile extends Profile{
    String FirstName = null;
    String LastName =null;
    String Password = null;

    //constructor
    public AdminProfile(){}

    //getters and setters
    public String getFirstName() {
        return this.FirstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}
