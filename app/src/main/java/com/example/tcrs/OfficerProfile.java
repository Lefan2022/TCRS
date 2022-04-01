package com.example.tcrs;

import android.os.Parcel;
import android.os.Parcelable;

public class OfficerProfile implements Parcelable {
    String ID = null;
    String FirstName = null;
    String LastName =null;
    String Password = null;

    //constructor
    public OfficerProfile(){}

    protected OfficerProfile(Parcel in) {
        ID = in.readString();
        FirstName = in.readString();
        LastName = in.readString();
        Password = in.readString();
    }

    public static final Creator<OfficerProfile> CREATOR = new Creator<OfficerProfile>() {
        @Override
        public OfficerProfile createFromParcel(Parcel in) {
            return new OfficerProfile(in);
        }

        @Override
        public OfficerProfile[] newArray(int size) {
            return new OfficerProfile[size];
        }
    };

    //getters and setters
    public String getID(){
        return this.ID;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setID(String ID){
        this.ID = ID;
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
        parcel.writeString(ID);
        parcel.writeString(FirstName);
        parcel.writeString(LastName);
        parcel.writeString(Password);
    }
}
