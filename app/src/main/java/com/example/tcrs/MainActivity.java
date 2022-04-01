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


    }

}