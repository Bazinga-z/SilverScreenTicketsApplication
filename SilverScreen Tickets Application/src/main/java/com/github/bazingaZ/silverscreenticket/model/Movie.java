package com.github.bazingaZ.silverscreenticket.model;

import java.util.List;

public class Movie {
    private int id;
    private String name;
    private List<Ticket> tickets;
    private int countOfTickets;


    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getCountOfTickets() {
        return tickets.size();
    }

    public int getId() {
        return id;
    }
}
