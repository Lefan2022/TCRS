package com.example.tcrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database db = new Database();
        Profile p = new Profile();
        db.AddProfile(p);


        //Passing the database from MainActivity to OfficerActivity
        //this is for OfficerActivity part, but you can use it as a template for your own activity
        //If your activity modified any data, you can use the same method to pass the database back
        Intent dbIntent = new Intent(MainActivity.this, OfficerActivity.class);
        dbIntent.putExtra("DatabaseKey", db);
        Intent[] myIntent = new Intent[1];
        myIntent[0] = dbIntent;
        startActivities(myIntent);


    }

}