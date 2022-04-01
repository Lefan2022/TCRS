package com.example.tcrs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String TicketNo[];
    Date dateList[];
    String violationType[];
    double fineAmount[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String TicketNo[], Date dateList[],String violationType[],double fineAmount[] ){
        this.context = context;
        this.TicketNo = TicketNo;
        this.dateList = dateList;
        this.violationType = violationType;
        this.fineAmount = fineAmount;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return TicketNo.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.history_list, null);
        TextView textView_ticket_no = (TextView) view.findViewById(R.id.textView_ticket_no);
        TextView textView_data_receieved = (TextView) view.findViewById(R.id.textView_data_receieved);
        TextView textView_violation_type = (TextView) view.findViewById(R.id.textView_violation_type);
        TextView textView_fine_amount = (TextView) view.findViewById(R.id.textView_fine_amount);

        textView_ticket_no.setText(TicketNo[i]);
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = formatter.format(dateList[i]);
        textView_data_receieved.setText(s);
        textView_violation_type.setText(violationType[i]);
        textView_fine_amount.setText("$"+String.valueOf(fineAmount[i]));
        return view;
    }
}
