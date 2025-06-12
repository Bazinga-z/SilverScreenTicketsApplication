package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CinemaHibernateImpShould {

    @Test
    void addMovieToDatabase() {
        Movie movie = new Movie("The A", "sci-fi", 149);
        Cinema cinema = new CinemaHibernateImp();
        cinema.addMovie(movie);
    }

    @Test
    void getMovieByHavingItsId() {
        Cinema cinema = new CinemaHibernateImp();
        Movie movie = cinema.getMovie(1);
        System.out.println("The id of movie is: " + movie.getId());
        System.out.println("The name of movie is: " + movie.getName());
        System.out.println("The genre of movie is: " + movie.getGenre());
        System.out.println("The duration of movie is: " + movie.getDuration());
        System.out.println("The count of tickets of movie are: " + movie.getCountOfTickets());
    }

    @Test
    void checkIfAMovieExists() {
        Cinema cinema = new CinemaHibernateImp();
        Movie movie = new Movie(1,"The Sacrifice",0, "darma", 149);
        Boolean ifMovieExists = cinema.existMovie(movie);
        System.out.println(ifMovieExists);
    }

    @Test
    void addTicketToDatabase() {
        CinemaHibernateImp cinema = new CinemaHibernateImp();
        Movie movie = cinema.getMovie(1);
        Ticket ticket = new Ticket(50, movie);
        cinema.addTicket(ticket);
    }

    @Test
    void getTicketsOfAMovie() {

        Cinema cinema = new CinemaHibernateImp();
        List<Ticket> tickets = cinema.getTickets(1);
        for (int i=0; i< tickets.size(); i++) {

            System.out.println(tickets.get(i).getId() + ") The price of ticket is: " + tickets.get(i).getPrice());
        }

    }
}
