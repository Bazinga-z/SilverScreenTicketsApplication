package com.github.bazingaZ.silverscreenticket.model;

import java.util.List;

public class Movie {
    private int id;
    private String name;
    private List<Ticket> tickets;
    private int countOfTickets;
    private String genre;
    private int duration;

    public Movie(int id) {
        this.id = id;
    }

    public Movie() {

    }

    public Movie(int id, String name, List<Ticket> tickets, String genre, int duration) {
        this.id = id;
        this.name = name;
        this.tickets = tickets;
        this.genre = genre;
        this.duration = duration;
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

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", countOfTickets=" + getCountOfTickets() +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                '}';
    }
}
