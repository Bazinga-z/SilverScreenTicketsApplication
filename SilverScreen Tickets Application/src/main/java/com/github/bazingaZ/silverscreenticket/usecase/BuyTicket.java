package com.github.bazingaZ.silverscreenticket.usecase;

import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;

import java.util.List;

public class BuyTicket {


    private static final int FIRT_TICKET = 0;
    private final Cinema cinema;

    public BuyTicket(Cinema cinema) {
        this.cinema = cinema;
    }

    public void add(List<Ticket> ticket, int movieId) {
        Movie movie = cinema.getMove(movieId);
        movie.setTickets(ticket);
    }

    public int buyTicket(int movieId, int numberOfRequestedTickets, int totalMoneyPaidForTickets) {

        Movie movie = cinema.getMove(movieId);
        List<Ticket> tickets = cinema.getTickets(movieId);

        if (tickets.isEmpty() || tickets.size() < numberOfRequestedTickets) {
            throw new NoTicketsLeftException("No Tickets Left For This Movie.");
        }


        Ticket ticket = tickets.get(FIRT_TICKET);
        int totalMoneyNeccessaryToBuyTickets = ticket.calculatePrice(numberOfRequestedTickets);

        //removing tickets from the end of the list.
        for (int index = 0; index < numberOfRequestedTickets; index++) {
            tickets.remove(tickets.size() - 1);
        }

        if (totalMoneyPaidForTickets < totalMoneyNeccessaryToBuyTickets) {
            throw new InsufficientMoneyException("Insufficient Money To Buy Tickets.");
        }

        return movie.getCountOfTickets();
    }
}
