package com.bignerdranch.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private Button login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        password = (EditText)findViewById(R.id.password);
        email = (EditText)findViewById(R.id.email);

        login = (Button)findViewById(R.id.login);



        TextView btn=findViewById(R.id.textViewSignUp);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUps.class));
            }
        });
    }

    public void validate(View view) {
        String name = email.getText().toString(); //calls it to string
        String pass = password.getText().toString();

        if (name.equals("genericPass") || pass.equals("haha")) {
            Intent intent = new Intent(this, profilePage.class); //Will take us to login information.

        } else if (name.equals("") || pass.equals("")) {
            Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "password/username Incorrect", Toast.LENGTH_SHORT).show();
        }
    }

}
