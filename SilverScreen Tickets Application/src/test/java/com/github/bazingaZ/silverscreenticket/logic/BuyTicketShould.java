package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.exception.InsufficientMoney;
import com.github.bazingaZ.silverscreenticket.exception.InsufficientTicket;
import com.github.bazingaZ.silverscreenticket.exception.MovieNotFound;
import com.github.bazingaZ.silverscreenticket.exception.NoTicketsLeft;
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
    void shouldNotAllowedBuyingTicketForAMovieIfThereIsNoTicketsLeft() {
        // Find the movie; if no tickets exist, throw a custom exception.

        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie();
        movies.add(movie);

        List<Ticket> tickets = new ArrayList<>();
        movie.setTickets(tickets);


        BuyTicket buyTicket = new BuyTicket(movies);
        int movieId = movie.getId();

        int totalMoneyPaidForTickets = 50000;

        Assertions.assertThatThrownBy(() -> buyTicket.buyTicket(movieId, 5, totalMoneyPaidForTickets))
                .isInstanceOf(NoTicketsLeft.class);

    }

    @Test
    void shouldNotAllowedBuyingTicketForNonExistentMovie() {
        // Try to find the movie; if the movie doesn't exist, throw a custom exception.

        List<Movie> movies = new ArrayList<>();

        BuyTicket buyTicket = new BuyTicket(movies);
        int movieId = 5;

        int totalMoneyPaidForTickets = 50000;

        Assertions.assertThatThrownBy(() -> buyTicket.buyTicket(movieId, 5, totalMoneyPaidForTickets))
                .isInstanceOf(MovieNotFound.class);

    }

    @Test
    void shouldReduceAvailableTicketsWhenPurchasing() {
        // Find the movie and get available tickets.
        // Deduct the number of tickets requested by the user.
        // Calculate the total price and complete the transaction if valid.
        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie(0);
        movies.add(movie);

        int movieId = movie.getId();
        BuyTicket buyTicket = new BuyTicket(movies);

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1, 50000, movieId));
        tickets.add(new Ticket(2, 50000, movieId));

        buyTicket.add(tickets, movieId);

        int totalMoneyPaidForTickets = 50000;

        int remainingNumberOfTickets = buyTicket.buyTicket(movieId, 1, totalMoneyPaidForTickets);

        Assertions.assertThat(movie.getCountOfTickets()).isEqualTo(remainingNumberOfTickets);
    }

    @Test
    void shouldPreventPurchaseWhenInsufficientFunds() {
        // Calculate total price and throw a custom exception if funds are insufficient.
        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie(0);
        movies.add(movie);

        int movieId = movie.getId();
        BuyTicket buyTicket = new BuyTicket(movies);

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1, 50000, movieId));
        tickets.add(new Ticket(2, 50000, movieId));

        buyTicket.add(tickets, movieId);

        int totalMoneyPaidForTickets = 40000;

        Assertions.assertThatThrownBy(() -> buyTicket.buyTicket(movieId, 1, totalMoneyPaidForTickets))
                .isInstanceOf(InsufficientMoney.class);


    }

    @Test
    void shouldPreventPurchaseWhenInsufficientTicket() {
        List<Movie> movies = new ArrayList<>();
        Movie movie = new Movie(0);
        movies.add(movie);

        int movieId = movie.getId();
        BuyTicket buyTicket = new BuyTicket(movies);

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(1, 50000, movieId));
        tickets.add(new Ticket(2, 50000, movieId));

        buyTicket.add(tickets, movieId);

        int totalMoneyPaidForTickets = 40000;

        Assertions.assertThatThrownBy(() -> buyTicket.buyTicket(movieId, 5, totalMoneyPaidForTickets))
                .isInstanceOf(InsufficientTicket.class);


    }


}