package com.example.tcrs;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Payment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paynow);
        TextView money = findViewById(R.id.amount);
        String amount = "username not set";

        Bundle extras = getIntent().getExtras();
        if(extras!= null){
            amount = extras.getString("amount");
        }
        money.setText(amount);
    }
}
