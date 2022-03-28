package com.example.tcrs;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Database implements Parcelable {
    //all the profiles stores in the ArrayList called db
    ArrayList<Profile> db = new ArrayList<Profile>();
    //size is the number of current profiles
    int size = 0;

    //constructor
    public Database() {}

    protected Database(Parcel in) {
        size = in.readInt();
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

    //Find the profile by providing id number of that profile
    public Profile FindProfileByID(String id){
        int temp = size;
        while(temp>0){
            if(db.get(temp-1).id == id){
                return db.get(temp-1);
            }else{
                temp--;
            }
        }
        return null;
    }

    //add a new profile to the database
    public Boolean AddProfile(Profile p){
        if(p.type == 1 || p.type == 2 || p.type == 3){
            if(p.id != null){
                db.add(p);
                size++;
                return true;
            }
        }
        return false;
    }

    //delete a existing profile
    public void DeleteProfile(Profile p){
        if(FindProfileByID(p.id) != null) {
            db.remove(p);
            size--;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(size);
    }
}

