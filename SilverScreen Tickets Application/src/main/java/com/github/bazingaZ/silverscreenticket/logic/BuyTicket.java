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

    public int buyTicket(int movieId, int numberOfRequestedTickets) {
        Movie movie = movies.get(movieId);
        if(movie.getCountOfTickets() == 0) {
            throw new NoTicketsLeftException("No Tickets Left For This Movie.");
        }

        //removing tickets from the end of the list.
        for(int i = 0; i < numberOfRequestedTickets; i++) {
            movie.getTickets().remove(movie.getTickets().size() - 1);
        }

        int remainingNumberOfTickets = movie.getCountOfTickets();
        return remainingNumberOfTickets;
    }
}
