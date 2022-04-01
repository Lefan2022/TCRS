package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class AddMoney extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_add_money, container, false);

        TextView textView = (TextView) view.findViewById(R.id.textView);
        ImageView Rbc = (ImageView)view.findViewById(R.id.rbc);
        ImageView Scotia = (ImageView) view.findViewById(R.id.scotia);
        ImageView TD = (ImageView) view.findViewById(R.id.td);
        ImageView BMO = (ImageView) view.findViewById(R.id.bmo);

        textView.setText("To add money select your bank and go to pay bill. Once there, enter TCRS ass payee and your license number as account number");

        Rbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www6.rbc.com/webapp/ukv0/signin/logon.xhtml?target=/");
            }
        });

        Scotia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.scotiabank.com/ca/en/personal/bank-your-way/app-and-online/online-banking.html");
            }
        });

        TD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://authentication.td.com/uap-ui/?consumer=easyweb&locale=en_CA#/uap/login");
            }
        });

        BMO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www1.bmo.com/onlinebanking/cgi-bin/netbnx/NBmain?product=5");
            }
        });

        return  view;
    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}