package com.bignerdranch.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUps extends AppCompatActivity {

    EditText firstName, lastName, password, confirmpassword, license, id;
    SharedPreferences registerDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        firstName = (EditText)findViewById(R.id.inputUsername);
        lastName = (EditText)findViewById(R.id.adminLast);
        password = (EditText)findViewById(R.id.confirmPassword);
        confirmpassword = (EditText)findViewById(R.id.editTextTextPersonName4);
        license = (EditText)findViewById(R.id.inputLicense);
        id = (EditText)findViewById(R.id.inputId);


        // get or create SharedPreferences
        SharedPreferences sharedPref = getSharedPreferences("myPref", MODE_PRIVATE);

        // save your string in SharedPreferences
        sharedPref.edit().putString("pk", String.valueOf(firstName)).commit();

        String userId = sharedPref.getString("pk", "default if empty");

        TextView clck=findViewById(R.id.adminRedirect);
        clck.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view){ //Redirects you to create an admin account
                    startActivity(new Intent(SignUps.this, RegisterAdminOrOfficer.class));
            }
        });


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
            String name = firstName.getText().toString(); //Gets and temporaily saves the typed information
            String last = lastName.getText().toString();
            String pass = password.getText().toString();
            String confirmpass = confirmpassword.getText().toString();
            String licenseplt = license.getText().toString();
            String uniqueid = id.getText().toString();
            Bundle data = getIntent().getExtras();
            Database database = new Database();
            DriverProfile driverprofile = new DriverProfile();

            if (name.length() > 0 &&  last.length() > 0 && pass.length() > 0 && confirmpass.equals(pass) && licenseplt.length() > 0 && uniqueid.length() > 0) {
                startActivity(new Intent(SignUps.this, LoginActivity.class));
                driverprofile.FirstName = name;
                driverprofile.LastName = last;
                driverprofile.Password = pass;
                driverprofile.LicenseNo = licenseplt;
                driverprofile.ID = uniqueid;


            } else if (!confirmpass.equals(pass)){
                Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();

            } else {
                Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show();
            }
    }
}