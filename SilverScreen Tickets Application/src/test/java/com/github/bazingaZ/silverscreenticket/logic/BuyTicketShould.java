package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BuyTicketShould {

    @Test
    void createTicketForExistingMovie() {
        // admin  ->  add ticket
        // movie - > ticket   20 - >  3000
        // Check if movie exists, otherwise throw an exception.
        // If found, add a ticket with a validated price.

        // given
        Movie movie = new Movie();
        List<Movie> movies = new ArrayList<>();
        movies.add(movie);

        var buyTicket = new BuyTicket(movies);
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1, 2, 0));
        int movieId = 0;
        buyTicket.add(tickets, movieId);
        Assertions.assertThat(1).isEqualTo(movie.getCountOfTickets());

    }

    @Test
    void shouldNotAllowedBuyingTicketForNonExistentMovie() {
        // Find the movie; if no tickets exist, throw a custom exception.

        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();
        movies.add(movie);

        List<Ticket> tickets = new ArrayList<>();
        movie.setTickets(tickets);


        BuyTicket buyTicket = new BuyTicket(movies);
        int movieId = movie.getId();

        Assertions.assertThatThrownBy(() -> buyTicket.buyTicket(movieId))
                .isInstanceOf(NoTicketsLeftException.class)
                .hasMessage("No Tickets Left For This Movie.");
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