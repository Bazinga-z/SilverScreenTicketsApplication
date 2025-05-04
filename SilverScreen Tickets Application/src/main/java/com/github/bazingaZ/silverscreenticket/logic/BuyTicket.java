package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.exception.InsufficientMoney;
import com.github.bazingaZ.silverscreenticket.exception.InsufficientTicket;
import com.github.bazingaZ.silverscreenticket.exception.MovieNotFound;
import com.github.bazingaZ.silverscreenticket.exception.NoTicketsLeft;
import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;

import java.util.List;

public class BuyTicket {

    private final Cinema cinema;


    public BuyTicket(Cinema cinema) {
        this.cinema = cinema;
    }

    public void add(List<Ticket> ticket, int movieId) {
        Movie movie = cinema.getMovie(movieId);
        movie.setTickets(ticket);
    }

    public Movie getMovie(int movieId) {
        return cinema.getMovie(movieId);
    }

    public int buyTicket(int movieId, int numberOfRequestedTickets, int totalMoneyPaidForTickets) {

        Movie movie = getMovie(movieId);

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

    public int getTotalPriceNeedToBePaidToBuyTickets(int numberOfRequestedTickets, int movieId) {
        int priceOfOneTicket = getMovie(movieId).getTickets().get(0).getPrice();
        return priceOfOneTicket * numberOfRequestedTickets;
    }

    public void checksIfThereIsEnoughTicketLeft(int movieId, int numberOfTickets) {

        if (getMovie(movieId).getCountOfTickets() == 0) {
            throw new NoTicketsLeft("No Tickets Left For This Movie.");
        }

        if (getMovie(movieId).getCountOfTickets() < numberOfTickets) {
            throw new InsufficientTicket("We Don't Have That Much Ticket.");
        }
    }
}
