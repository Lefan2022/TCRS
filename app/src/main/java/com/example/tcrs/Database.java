package com.example.tcrs;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

public class Database implements Parcelable {
    //all the profiles stores in the ArrayList called db
    ArrayList<OfficerProfile> Officer_db = new ArrayList<OfficerProfile>();
    ArrayList<DriverProfile> Driver_db = new ArrayList<DriverProfile>();
    ArrayList<AdminProfile> Admin_db = new ArrayList<AdminProfile>();
    //size is the number of current profiles
    int Officer_size = 0;
    int Driver_size = 0;
    int Admin_size = 0;

    //constructor
    public Database() {}

    //serialize attributes
    public Database(Parcel in){
        this.Officer_size = in.readInt();
        this.Driver_size = in.readInt();
        this.Admin_size = in.readInt();
        this.Officer_db = in.createTypedArrayList(OfficerProfile.CREATOR);
        this.Driver_db = in.createTypedArrayList(DriverProfile.CREATOR);
        this.Admin_db = in.createTypedArrayList(AdminProfile.CREATOR);
    }

    public static final Creator<Database> CREATOR = new Creator<Database>() {
        @Override
        public Database createFromParcel(Parcel in) {
            return new Database(in);
        }

        @Override
        public Database[] newArray(int size) {
            return new Database[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.Officer_size);
        parcel.writeInt(this.Driver_size);
        parcel.writeInt(this.Admin_size);
        parcel.writeTypedList(this.Officer_db);
        parcel.writeTypedList(this.Driver_db);
        parcel.writeTypedList(this.Admin_db);
    }

    //Find the profile by providing id number of that profile
    public OfficerProfile FindOfficerProfileByID(String id){
        int temp = Officer_size;
        while(temp>0){
            if(Officer_db.get(temp-1).ID.equals(id)){
                return Officer_db.get(temp-1);
            }else{
                temp--;
            }
        }
        return null;
    }

    //add a new profile to the database
    public Boolean AddOfficerProfile(OfficerProfile p){
        if(p.ID != null){
            Officer_db.add(p);
            Officer_size++;
            return true;
        }

        return false;
    }

    //delete a existing profile
    public void DeleteOfficerProfile(OfficerProfile p){
        if(FindOfficerProfileByID(p.ID) != null) {
            Officer_db.remove(p);
            Officer_size--;
        }
    }

    //Find the profile by providing id number of that profile
    public DriverProfile FindDriverProfileByID(String id){
        int temp = Driver_size;
        while(temp>0){
            if(Driver_db.get(temp-1).ID.equals(id)){
                return Driver_db.get(temp-1);
            }else{
                temp--;
            }
        }

        return null;
    }

    //add a new profile to the database
    public Boolean AddDriverProfile(DriverProfile p){
        if(p.ID != null){
            Driver_db.add(p);
            Driver_size++;
            return true;
        }

        return false;
    }

    //delete a existing profile
    public void DeleteDriverProfile(DriverProfile p){
        if(FindDriverProfileByID(p.ID) != null) {
            Driver_db.remove(p);
            Driver_size--;
        }
    }
}