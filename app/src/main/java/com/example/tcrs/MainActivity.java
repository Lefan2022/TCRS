package com.example.tcrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database database = new Database();
<<<<<<< Updated upstream
        Profile p = new Profile();
        p.setId("001");
        p.setType(1);
        database.AddProfile(p);


        //Passing the database from MainActivity to OfficerActivity
        //this is for OfficerActivity part, but you can use it as a template for your own activity
        //If your activity modified any data, you can use the same method to pass the database back
        Intent dbIntent = new Intent(MainActivity.this, OfficerActivity.class);
        dbIntent.putExtra("DatabaseKey", database);
        startActivity(dbIntent);
=======

        DriverProfile firstDriver = new DriverProfile();
        firstDriver.setID("001");
        firstDriver.setBalance(0);
        firstDriver.setFirstName("First");
        firstDriver.setLastName("Driver");
        firstDriver.setPassword("123456");
        firstDriver.setLicenseNo("001");

        OfficerProfile firstOfficer = new OfficerProfile();
        firstOfficer.setID("101");
        firstOfficer.setFirstName("First");
        firstOfficer.setLastName("Officer");
        firstOfficer.setPassword("987654");

        database.AddDriverProfile(firstDriver);
        database.AddOfficerProfile(firstOfficer);



        Intent OfficerIntent = new Intent(MainActivity.this, OfficerActivity.class);
        OfficerIntent.putExtra("DatabaseKey", database);
        OfficerIntent.putExtra("myProfile",firstOfficer);
        startActivity(OfficerIntent);
>>>>>>> Stashed changes

    }

}