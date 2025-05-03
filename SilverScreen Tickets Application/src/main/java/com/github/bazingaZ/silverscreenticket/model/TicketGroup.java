package com.github.bazingaZ.silverscreenticket.model;

import com.github.bazingaZ.silverscreenticket.usecase.NoTicketsLeftException;

import java.util.List;

public class TicketGroup {

    private final List<Ticket> tickets;

    public TicketGroup(List<Ticket> tickets) {
        this.tickets = tickets;
    }


    public int calculatePrice(int countOfTicket) {
        existLengthTicket(countOfTicket);
        int totalPrice = 0;
        for (int index = 0; index < countOfTicket; index++) {
            Ticket ticket = tickets.get(index);
            totalPrice += ticket.getPrice();
        }
        return totalPrice;
    }

    public void remove(int countOfTicket) {
        existLengthTicket(countOfTicket);
        for (int index = 0; index < countOfTicket; index++) {
            tickets.remove(tickets.size() - 1);
        }

    }

    private void existLengthTicket(int countOfTicket) {
        if (tickets.size() < countOfTicket)
            throw new NoTicketsLeftException("");
    }

}
