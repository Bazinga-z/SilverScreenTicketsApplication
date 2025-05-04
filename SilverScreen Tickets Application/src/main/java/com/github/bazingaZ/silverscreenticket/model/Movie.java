package com.github.bazingaZ.silverscreenticket.model;

import java.util.List;

public class Movie {
    private int id;
    private String name;
    private List<Ticket> tickets;
    private int countOfTickets;

    public Movie(int id) {
        this.id = id;
    }

    public Movie() {

    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public int getCountOfTickets() {
        return tickets.size();
    }

    public int getId() {
        return id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }


}
