package com.example.tcrs;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class profilePage2 extends AppCompatActivity {

    BottomNavigationView navigationView;
    Paytickets pay = new Paytickets();
    ProfilePage profilef = new ProfilePage();
    AddMoney add = new AddMoney();
    TicketHistoryPage history = new TicketHistoryPage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView =  findViewById(R.id.bottomNavigationView);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,profilef).commit();
        BadgeDrawable badgeDrawable = navigationView.getOrCreateBadge(R.id.ticketHistory);
        badgeDrawable.setVisible(true);
        badgeDrawable.setNumber(8);


        navigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener(){

            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.paytickets:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,pay).commit();
                        return true;
                    case R.id.addMoney:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,add).commit();
                        return true;
                    case R.id.profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,profilef).commit();
                        return true;
                    case R.id.ticketHistory:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView,history).commit();
                        return true;

                }

                return false;
            }
        });

    }
}
