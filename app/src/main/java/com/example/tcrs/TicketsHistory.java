package com.example.tcrs;

import java.util.ArrayList;

//TicketsHistory is a ArrayList contains all the tickets a driver received
public class TicketsHistory {
    ArrayList<Tickets> HistoryList = new ArrayList<Tickets>();

    public TicketsHistory(){}

    //add a ticket to the list if it's valid
    public void AddTickets(Tickets t) throws Exception {
        if(t.TicketsNo != null){
            if(t.FineAmount >= 0){
                if(t.ViolationType != null){
                    if(t.DateReceived != null){
                        HistoryList.add(t);
                    }else{
                        throw new NullPointerException("Date should not be empty");
                    }
                }else{
                    throw new NullPointerException("Violation type should not be empty.");
                }
            }else{
                throw new Exception("Fine Amount should be bigger than 0.");
            }
        }else{
            throw new NullPointerException("Tickets number should not be empty.");
        }
    }

    //delete a ticket from the list
    public void DeleteTicket(Tickets t) throws Exception{
        if (FindTicketsByNo(t.TicketsNo) != null){
            HistoryList.remove(t);
        }else{
            throw new Exception("Ticket with the number "+t.TicketsNo+" is not in the list.");
        }
    }

    //find a ticket by it's ticket number
    public Tickets FindTicketsByNo(String ticketNo){
        int size = HistoryList.size();
        while(size>0){
            if(HistoryList.get(size-1).TicketsNo == ticketNo){
                return HistoryList.get(size-1);
            }else{
                size--;
            }
        }
        return null;
    }
}
