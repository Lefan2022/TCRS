package com.example.tcrs;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.MyViewHolder> {
    private ArrayList<Tickets>ticketsList;
    private RecyclerViewCLickListener listener;

    public myadapter(ArrayList<Tickets>ticketsList, RecyclerViewCLickListener listener) {
        this.ticketsList = ticketsList;
        this.listener = listener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nametxt;

        public MyViewHolder(final View view) {
            super(view);
            nametxt = view.findViewById(R.id.tinfo);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(view, getAdapterPosition());

        }
    }



    @NonNull
    @Override
    public myadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitems,parent, false);
        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.MyViewHolder holder, int position) {
        String ticket = String.valueOf(ticketsList.get(position).getTicketsNo());
        holder.nametxt.setText(ticket);


    }

    @Override
    public int getItemCount() {
        return ticketsList.size();
    }

    public interface RecyclerViewCLickListener{
        void onClick(View view, int position);

    }

}
