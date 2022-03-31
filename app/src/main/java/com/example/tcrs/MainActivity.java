package com.example.tcrs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Database database = new Database();
//        Profile firstDriver = new DriverProfile();
//        firstDriver.setType(3);
//        firstDriver.setId("001");
//        firstDriver.setBalance(0);
//        firstDriver.setFirstName("First");
//        firstDriver.setLastName("Driver");
//        firstDriver.setPassword("123456");
//        firstDriver.setLicenseNo("001");
//        database.AddProfile(firstDriver);


        Intent OfficerIntent = new Intent(MainActivity.this, OfficerActivity.class);
        OfficerIntent.putExtra("DatabaseKey", database);
        startActivity(OfficerIntent);

    }

}