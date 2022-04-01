package com.example.tcrs;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Date;



public class OfficerActivity extends AppCompatActivity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.officer_issue_ticket);

        //this line of code is to fetch the database object from MainActivity
        Bundle data = getIntent().getExtras();
        Database database = (Database) data.getParcelable("DatabaseKey");
        OfficerProfile me = data.getParcelable("myProfile");



        Button button_issue = findViewById(R.id.button_issue);
        Button button_issue_ticket = findViewById(R.id.button_issue_ticket);
        Button button_check = findViewById(R.id.button_check);
        Button button_profile = findViewById(R.id.button_profile);
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
            //Fine amount must be a number
            try{
                Double.parseDouble(editText_fineAmount.getText().toString());
            }catch (Exception e){
                Toast.makeText(this,"Fine amount must be a number.",Toast.LENGTH_LONG).show();
            }
            if(flag){
                Tickets newTicket = new Tickets();
                //ticketNo = driverID number+this driver's total tickets number
                newTicket.setTicketsNo(editText_driverID.getText().toString()+Integer.toString(database.FindDriverProfileByID(editText_driverID.getText().toString()).TicketHistory.HistoryList.size()));
                newTicket.setDateReceived(new Date());
                try {
                    newTicket.setFineAmount(Double.parseDouble(editText_fineAmount.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
                newTicket.setViolationType(editText_violationType.getText().toString());
                try {
                    database.FindDriverProfileByID(editText_driverID.getText().toString()).TicketHistory.AddTickets(newTicket);
                    Toast.makeText(this,"success",Toast.LENGTH_LONG).show();
                    editText_driverID.setText(null);
                    editText_violationType.setText(null);
                    editText_fineAmount.setText(null);
                } catch (Exception e) {
                    Toast.makeText(this,"fail",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });

        button_check.setOnClickListener(v -> {
            setContentView(R.layout.officer_check);


            EditText searchBar = (EditText) findViewById(R.id.searchbar);
            Button button_search = findViewById(R.id.button_search);
            Button button_return = findViewById(R.id.button_return);

            button_search.setOnClickListener(v2 -> {
                String searchKey = searchBar.getText().toString();
                ListView listView;

                ArrayList<Tickets> ticketsList = database.FindDriverProfileByID(searchKey).TicketHistory.HistoryList;
                String TicketNos[] = new String[ticketsList.size()];
                for(int i = ticketsList.size(); i>0; i-- ){
                    TicketNos[i-1] = ticketsList.get(i-1).TicketsNo;
                }
                Date dateList[] = new Date[ticketsList.size()];
                for(int i = ticketsList.size(); i>0; i-- ){
                    dateList[i-1] = ticketsList.get(i-1).DateReceived;
                }
                String violationType[] = new String[ticketsList.size()];
                for(int i = ticketsList.size(); i>0; i-- ){
                    violationType[i-1] = ticketsList.get(i-1).ViolationType;
                }
                double fineAmount[] = new double[ticketsList.size()];
                for(int i = ticketsList.size(); i>0; i-- ){
                    fineAmount[i-1] = ticketsList.get(i-1).getFineAmount();
                }

                listView = (ListView)findViewById(R.id.HistoryList);

                CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), TicketNos, dateList, violationType,fineAmount);

                listView.setAdapter(customAdapter);
            });

            //refresh
            button_return.setOnClickListener(v2 -> {
                Intent refresh = new Intent(OfficerActivity.this, OfficerActivity.class);
                refresh.putExtra("DatabaseKey", database);
                refresh.putExtra("myProfile",me);
                startActivity(refresh);
            });
        });

        button_profile.setOnClickListener(v3 -> {
            setContentView(R.layout.officer_profile_page);
            TextView textView = (TextView) findViewById(R.id.textView);
            TextView textView_firstName = (TextView) findViewById(R.id.textView_firstName);
            TextView textView_lastName =(TextView) findViewById(R.id.textView_lastName);
            TextView textView_idNo = (TextView) findViewById(R.id.textView_idNo);
            Button button_profile_return = (Button) findViewById(R.id.button_profile_return);

            String FirstName = database.FindOfficerProfileByID(me.ID).FirstName;
            String LastName = database.FindOfficerProfileByID(me.ID).LastName;

            textView_firstName.setText("FirstName: "+FirstName);
            textView_lastName.setText("LastName: "+LastName);
            textView_idNo.setText("Officer ID: "+me.ID);

            button_profile_return.setOnClickListener(v4-> {
                Intent refresh = new Intent(OfficerActivity.this, OfficerActivity.class);
                refresh.putExtra("DatabaseKey", database);
                refresh.putExtra("myProfile",me);
                startActivity(refresh);
            });

        });

    }


}
