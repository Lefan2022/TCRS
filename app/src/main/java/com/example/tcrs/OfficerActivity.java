package com.example.tcrs;

import android.app.Activity;
import android.content.Intent;

public class OfficerActivity extends Activity {

    //this line of code is to fetch the database object from MainActivity
    Database db = getIntent().getParcelableExtra("DatabaseKey");

}
