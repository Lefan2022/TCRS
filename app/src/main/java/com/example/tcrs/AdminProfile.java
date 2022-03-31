package com.example.tcrs;

import android.os.Parcel;
import android.os.Parcelable;

public class AdminProfile implements Parcelable {
    String FirstName = null;
    String LastName =null;
    String Password = null;

    //constructor
    public AdminProfile(){}

    protected AdminProfile(Parcel in) {
        FirstName = in.readString();
        LastName = in.readString();
        Password = in.readString();
    }

    public static final Creator<AdminProfile> CREATOR = new Creator<AdminProfile>() {
        @Override
        public AdminProfile createFromParcel(Parcel in) {
            return new AdminProfile(in);
        }

        @Override
        public AdminProfile[] newArray(int size) {
            return new AdminProfile[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(FirstName);
        parcel.writeString(LastName);
        parcel.writeString(Password);
    }
}
