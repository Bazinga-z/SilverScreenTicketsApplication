package com.github.bazingaZ.silverscreenticket.usecase;

import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;
import com.github.bazingaZ.silverscreenticket.model.TicketGroup;

import java.util.List;

public class BuyTicket {


    private final Cinema cinema;

    public BuyTicket(Cinema cinema) {
        this.cinema = cinema;
    }

    public void add(List<Ticket> ticket, int movieId) {
        Movie movie = getMove(movieId);
        movie.setTickets(ticket);
    }

    public int buy(int movieId, int numberOfRequestedTickets, int totalMoneyPaidForTickets) {

        Movie movie = getMove(movieId);
        List<Ticket> tickets = cinema.getTickets(movieId);
        TicketGroup ticketGroup = new TicketGroup(tickets);

        int totalMoneyNecessary =
                ticketGroup.calculatePrice(numberOfRequestedTickets);

        ticketGroup.remove(numberOfRequestedTickets);

        if (totalMoneyPaidForTickets < totalMoneyNecessary) {
            throw new InsufficientMoneyException("Insufficient Money To Buy Tickets.");
        }

        return movie.getCountOfTickets();
    }

    private Movie getMove(int movieId) {
        return cinema.getMove(movieId);
    }
}
