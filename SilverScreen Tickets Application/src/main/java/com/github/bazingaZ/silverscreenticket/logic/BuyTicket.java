package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;

import java.util.List;

public class BuyTicket {
    private final List<Movie> movies;

    public BuyTicket(List<Movie> movies) {
        this.movies = movies;
    }

    public void add(List<Ticket> ticket, int movieId) {
        Movie movie = movies.get(movieId);
        movie.setTickets(ticket);
    }

    public void buyTicket(int movieId) {
        Movie movie = movies.get(movieId);
        if(movie.getCountOfTickets() == 0) {
            throw new NoTicketsLeftException("No Tickets Left For This Movie.");
        }
    }
}
