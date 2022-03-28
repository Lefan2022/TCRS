package com.example.tcrs;

import android.app.Activity;
import android.os.Bundle;


public class OfficerActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.officer_layout);

        //this line of code is to fetch the database object from MainActivity
        Database database = (Database) getIntent().getSerializableExtra("DatabaseKey");

    }

}
