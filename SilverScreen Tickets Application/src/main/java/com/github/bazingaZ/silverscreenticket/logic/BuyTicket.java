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

    public int buyTicket(int movieId, int numberOfRequestedTickets, int totalMoneyPaidForTickets) {
        Movie movie = movies.get(movieId);
        if(movie.getCountOfTickets() == 0) {
            throw new NoTicketsLeftException("No Tickets Left For This Movie.");
        }

        int totalMoneyNeccessaryToBuyTickets = 0;

        //removing tickets from the end of the list.
        for(int i = 0; i < numberOfRequestedTickets; i++) {
           Ticket ticket = movie.getTickets().get(movie.getTickets().size() - 1);
           totalMoneyNeccessaryToBuyTickets += ticket.getPrice();
            movie.getTickets().remove(movie.getTickets().size() - 1);
        }

        if(totalMoneyPaidForTickets < totalMoneyNeccessaryToBuyTickets) {
            throw new InsufficientMoneyException("Insufficient Money To Buy Tickets.");
        }

        int remainingNumberOfTickets = movie.getCountOfTickets();
        return remainingNumberOfTickets;
    }
}
