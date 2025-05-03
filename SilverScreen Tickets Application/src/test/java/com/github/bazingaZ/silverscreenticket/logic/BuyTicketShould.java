package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.model.Move;
import com.github.bazingaZ.silverscreenticket.model.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BuyTicketShould {

    @Test
    void createTicketForExistingMovie() {
        // admin  ->  add ticket
        // move - > ticket   20 - >  3000
        // Check if movie exists, otherwise throw an exception.
        // If found, add a ticket with a validated price.

        // given
        Move move = new Move();
        List<Move> moves = new ArrayList<>();
        moves.add(move);

        var buyTicket = new BuyTicket(moves);
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1, 2, 0));
        int moveId = 0;
        buyTicket.add(tickets, moveId);
        Assertions.assertThat(1).isEqualTo(move.getCountOfTickets());

    }

    @Test
    void shouldNotAllowedBuyingTicketForNonExistentMovie() {
        // Find the movie; if no tickets exist, throw a custom exception.
    }

    @Test
    void shouldReduceAvailableTicketsWhenPurchasing() {
        // Find the movie and get available tickets.
        // Deduct the number of tickets requested by the user.
        // Calculate the total price and complete the transaction if valid.
    }

    @Test
    void shouldPreventPurchaseWhenInsufficientFunds() {
        // Calculate total price and throw a custom exception if funds are insufficient.
    }


}