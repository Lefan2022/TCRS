package com.bignerdranch.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterAdminOrOfficer extends AppCompatActivity {

    EditText user, lastname, id, pass, confirmPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_admin_or_officer);
        TextView redirectToSignIn = findViewById(R.id.redirectLogin); //Now the object is created
        TextView redirectToRegister = findViewById(R.id.redirectSignUp);
        TextView buttonclick = findViewById(R.id.signUpButton);

        user = (EditText)findViewById(R.id.inputUsername);
        lastname = (EditText)findViewById(R.id.adminLast);
        id = (EditText)findViewById(R.id.adminId);
        pass = (EditText)findViewById(R.id.adminPassConfirm);
        confirmPass = (EditText)findViewById(R.id.adminPassConfirm2);
        //Now with the textView object created

        redirectToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterAdminOrOfficer.this, LoginActivity.class));
            }
        });

        redirectToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterAdminOrOfficer.this, SignUps.class));
            }
        });


    }

    public void validate(View view) { //onClick validate
        String name = user.getText().toString();
        String last = lastname.getText().toString();
        String identification = id.getText().toString();
        String password = pass.getText().toString();
        String confirm = confirmPass.getText().toString();
        OfficerProfile officer = new OfficerProfile();

        if (name.length() > 0 && last.length() > 0 && password.length() > 0 && password.equals(confirm) && name.length() > 0 && identification.length() > 0) {
            startActivity(new Intent(RegisterAdminOrOfficer.this, LoginActivity.class));
            officer.LastName = last;
            officer.FirstName = name;
            officer.Password = password;
            officer.ID = identification;

        } else if (!confirm.equals(password)) {
            Toast.makeText(this, "Password does not match", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Empty Fields", Toast.LENGTH_SHORT).show();
        }
    }
}