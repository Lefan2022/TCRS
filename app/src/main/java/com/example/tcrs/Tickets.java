package com.example.tcrs;

import java.util.Date;

//Ticket object
public class Tickets {
    String TicketsNo = null;
    Date DateReceived = null;
    String ViolationType =null;
    double FineAmount = 0;

    //constructor
    public Tickets(){}

    //getters and setters
    public String getTicketsNo() {
        return this.TicketsNo;
    }

    public Date getDateReceived(){
        return this.DateReceived;
    }

    public String getViolationType(){
        return this.ViolationType;
    }

    public double getFineAmount(){
        return this.FineAmount;
    }

    public void setTicketsNo(String ticketsNo) {
        this.TicketsNo = ticketsNo;
    }

    public void setDateReceived(Date dateReceived) {
        this.DateReceived = dateReceived;
    }

    public void setViolationType(String violationType) {
        this.ViolationType = violationType;
    }

    public void setFineAmount(double fineAmount) {
        this.FineAmount = fineAmount;
    }
}
