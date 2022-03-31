package com.bignerdranch.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class SignUps extends AppCompatActivity {

    EditText firstName, lastName, password, confirmpassword, license;
    SharedPreferences registerDatabase;
    String[] db;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        firstName = (EditText)findViewById(R.id.inputUsername);
        lastName = (EditText)findViewById(R.id.lastName);
        password = (EditText)findViewById(R.id.confirmPassword);
        confirmpassword = (EditText)findViewById(R.id.editTextTextPersonName4);
        license = (EditText)findViewById(R.id.inputLicense);

        // get or create SharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("myPref", MODE_PRIVATE);

        // save your string in SharedPreferences
        sharedPref.edit().putString("pk", String.valueOf(firstName)).commit();

        String userId = sharedPref.getString("pk", "default if empty");






        TextView btn=findViewById(R.id.alrdyhaveacc);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {







                    //Scanner goes here Once they click sign up, It will store in the scanner. up or beneath.
                    startActivity(new Intent(SignUps.this, LoginActivity.class));
            }
        });

        }

        public void validate (View view) { //Had to set to validate in XML to match, onCick(Similar to click listner.
            String name = firstName.getText().toString();
            String last = lastName.getText().toString();
            String pass = password.getText().toString();
            String confirmpass = confirmpassword.getText().toString();
            String licenseplt = license.getText().toString();
            int i = 0;


            if (name.length() > 0 &&  last.length() > 0 && pass.length() > 0 && confirmpass.equals(pass) && licenseplt.length() > 0) {
                startActivity(new Intent(SignUps.this, LoginActivity.class));

            } else if (!confirmpass.equals(pass)){
                Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show();
            }


        }





}