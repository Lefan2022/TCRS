package com.example.tcrs;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;


public class OfficerActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.officer_issue_ticket);

        //this line of code is to fetch the database object from MainActivity
        Database database = (Database) getIntent().getSerializableExtra("DatabaseKey");

        Button button_issue = findViewById(R.id.button_issue);
       // Button button_
        EditText editText_driverID = findViewById(R.id.editText_driverID);
        EditText editText_violationType = findViewById(R.id.editText_violationType);
        EditText editText_fineAmount = findViewById(R.id.editText_fineAmount);

        button_issue.setOnClickListener(v -> {
            Boolean flag = true;
            if(editText_driverID.getText().toString().isEmpty()){
                flag = false;
                Toast.makeText(this,"Driver ID cannot be empty.",Toast.LENGTH_LONG).show();
            } else if(editText_violationType.getText().toString().isEmpty()){
                flag = false;
                Toast.makeText(this,"Violation type cannot be empty.",Toast.LENGTH_LONG).show();
            } else if(editText_fineAmount.getText().toString().isEmpty()){
                flag = false;
                Toast.makeText(this,"Fine amount cannot be empty.",Toast.LENGTH_LONG).show();
            }
            if(flag){
                Tickets newTicket = new Tickets();
                newTicket.setTicketsNo(Integer.toString(database.size));
                newTicket.setDateReceived(new Date());
                newTicket.setFineAmount(Double.parseDouble(editText_fineAmount.getText().toString()));
                newTicket.setViolationType(editText_violationType.toString());
                //DriverProfile driverProfile = database.FindProfileByID(editText_driverID.toString());
                if (database.FindProfileByID(editText_driverID.toString()) instanceof DriverProfile){
                    try {
                        ((DriverProfile) database.FindProfileByID(editText_driverID.toString())).TicketHistory.AddTickets(newTicket);
                        Toast.makeText(this,"success",Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(this,"fail",Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                    ;
                }else{
                //Toast.makeText(this,"?",Toast.LENGTH_LONG).show();}
            }

            if(database.FindProfileByID("001") != null){
                Toast.makeText(this,"success",Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this,"fail",Toast.LENGTH_LONG).show();}
            }
        });

    }

}
