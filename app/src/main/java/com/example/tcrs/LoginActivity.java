package com.bignerdranch.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText email, password;
    private Button login;
    private RadioButton radio1, radio2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        password = (EditText)findViewById(R.id.password);
        email = (EditText)findViewById(R.id.email);
        login = (Button)findViewById(R.id.login);
        radio1 = (RadioButton)findViewById(R.id.driverRadio);
        radio2 = (RadioButton)findViewById(R.id.officerRadio);

        TextView btn=findViewById(R.id.textViewSignUp);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUps.class));
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        //Check which button is clicked
        switch(view.getId()) {
            case R.id.driverRadio:
                if (checked)
                    break;
            case R.id.officerRadio:
                if (checked)
                    break;
        }
    }

    public void validate(View view) {
        String name = email.getText().toString(); //calls it to string
        String pass = password.getText().toString();
        Database database = new Database();


        if (name.equals(database.Driver_db) && pass.equals(database.Driver_db) && radio1.isChecked()) { //If radio 1 is checked then send to driver profile
            startActivity(new Intent(LoginActivity.this, SignUps.class));

        } else if (name.equals(database.Officer_db) && pass.equals(database.Officer_db) && radio2.isChecked()) { //If radio 1 is checked then send to officer profile
            startActivity(new Intent(LoginActivity.this, SignUps.class));
        } else if (!radio1.isChecked() && !radio2.isChecked()) {
            Toast.makeText(this, "Please select whether you are a driver or officer", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Please enter a valid ID or password", Toast.LENGTH_SHORT).show();
        }
    }
}
