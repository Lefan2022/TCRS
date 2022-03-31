package com.example.tcrs;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Paytickets extends Fragment {
    private ArrayList<Tickets>ticketlist;
    private RecyclerView recyclerView;
    private myadapter.RecyclerViewCLickListener listener;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_paytickets, container, false);
        recyclerView = (RecyclerView)v.findViewById(R.id.rcView);
        ticketlist = new ArrayList<>();
        setAdapter();


        return v;
    }
    private void setAdapter(){
        setOnClickListener();
        myadapter adapter = new myadapter(ticketlist, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator() );
        recyclerView.setAdapter(adapter);

    }

    private void setOnClickListener() {
        listener = new myadapter.RecyclerViewCLickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent intent = new Intent (getActivity().getApplicationContext(),Payment.class);
                intent.putExtra("amount",ticketlist.get(position).getFineAmount());
                startActivity(intent);
            }
        };
    }

}