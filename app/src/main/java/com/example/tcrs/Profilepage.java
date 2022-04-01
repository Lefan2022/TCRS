package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Profilepage extends AppCompatActivity {

    BottomNavigationView navigationView;
    Paytickets pay = new Paytickets();
    HomeProfilePage prof = new HomeProfilePage();
    AddMoney add = new AddMoney();
    TicketHistoryPage history = new TicketHistoryPage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profilehomepage);

        navigationView =  findViewById(R.id.bottom_naviagtion);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,prof).commit();
        BadgeDrawable badgeDrawable = navigationView.getOrCreateBadge(R.id.ticketHistory);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(8);


        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.paytickets:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,pay).commit();
                        return true;
                    case R.id.addMoney:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,add).commit();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,prof).commit();
                        return true;
                    case R.id.ticketHistory:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,history).commit();
                        return true;
                }
                return false;
            }
        });

    }
}

