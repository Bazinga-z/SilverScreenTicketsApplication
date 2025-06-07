package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.util.List;

class CinemaJdbcImpShould {

    @Test
    void addMovieToDatabase() {
        Movie movie = new Movie("The Sacrifice", "darma", 149);
        Cinema cinema = new CinemaJdbcImp();
        cinema.addMovie(movie);
    }

    @Test
    void getMovieByHavingItsId() {
        Cinema cinema = new CinemaJdbcImp();
        Movie movie = cinema.getMovie(1);
        System.out.println("The id of movie is: " + movie.getId());
        System.out.println("The name of movie is: " + movie.getName());
        System.out.println("The genre of movie is: " + movie.getGenre());
        System.out.println("The duration of movie is: " + movie.getDuration());
        System.out.println("The count of tickets of movie are: " + movie.getCountOfTickets());
    }

    @Test
    void checkIfAMovieExists() {
        Cinema cinema = new CinemaJdbcImp();
        Movie movie = new Movie(1,"The Sacrifice",0, "darma", 149);
        Boolean ifMovieExists = cinema.existMovie(movie);
        System.out.println(ifMovieExists);
    }

    @Test
    void addTicketToDatabase() {
        Ticket ticket = new Ticket(50, 1);
        CinemaJdbcImp cinema = new CinemaJdbcImp();
        cinema.addTicket(ticket);
    }

    @Test
    void getTicketsOfAMovie() {

        Cinema cinema = new CinemaJdbcImp();
        List<Ticket> tickets = cinema.getTickets(1);
        for (int i=0; i< tickets.size(); i++) {

            System.out.println(tickets.get(i).getId() + ") The price of ticket is: " + tickets.get(i).getPrice());
        }

    }
}
