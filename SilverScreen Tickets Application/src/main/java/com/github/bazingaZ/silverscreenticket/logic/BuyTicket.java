package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.exception.InsufficientMoney;
import com.github.bazingaZ.silverscreenticket.exception.InsufficientTicket;
import com.github.bazingaZ.silverscreenticket.exception.MovieNotFound;
import com.github.bazingaZ.silverscreenticket.exception.NoTicketsLeft;
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

    public Movie getMovie(int movieId) {
        try {
            return movies.get(movieId);
        } catch (Exception exception) {
            throw new MovieNotFound("No Movie With That Id Exists");
        }
    }

    public int buyTicket(int movieId, int numberOfRequestedTickets, int totalMoneyPaidForTickets) {

        Movie movie = getMovie(movieId);

        if (movie.getCountOfTickets() == 0) {
            throw new NoTicketsLeft("No Tickets Left For This Movie.");
        }

        if (movie.getCountOfTickets() < numberOfRequestedTickets) {
            throw new InsufficientTicket("We Don't Have That Much Ticket.");
        }


        int totalMoneyNeccessaryToBuyTickets = 0;

        //removing tickets from the end of the list.
        for (int i = 0; i < numberOfRequestedTickets; i++) {
            Ticket ticket = movie.getTickets().get(movie.getTickets().size() - 1);
            totalMoneyNeccessaryToBuyTickets += ticket.getPrice();
            movie.getTickets().remove(movie.getTickets().size() - 1);
        }

        if (totalMoneyPaidForTickets < totalMoneyNeccessaryToBuyTickets) {
            throw new InsufficientMoney("Insufficient Money To Buy Tickets.");
        }

        int remainingNumberOfTickets = movie.getCountOfTickets();
        return remainingNumberOfTickets;
    }
}
