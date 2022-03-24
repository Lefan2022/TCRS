package com.example.tcrs;

import java.util.ArrayList;

public class Database {
    //all the profiles stores in the ArrayList called db
    ArrayList<Profile> db = new ArrayList<Profile>();
    //size is the number of current profiles
    int size = 0;

    //constructor
    public Database() {}

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
}

