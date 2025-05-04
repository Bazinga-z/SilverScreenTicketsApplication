package com.github.bazingaZ.silverscreenticket.repository;

import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class MovieSamples {

    private List<Movie> movies = new ArrayList<>();
    private List<Ticket> tickets1 = new ArrayList<>();
    private List<Ticket> tickets2 = new ArrayList<>();
    private List<Ticket> tickets3 = new ArrayList<>();

    public void setTickets() {
        tickets1.clear();  // Always clear before adding new tickets
        tickets2.clear();
        tickets3.clear();

        tickets1.add(new Ticket(1,2000,1));
        tickets1.add(new Ticket(2,2000,1));
        tickets1.add(new Ticket(3,2000,1));
        tickets2.add(new Ticket(1,2000,2));
        tickets2.add(new Ticket(2,2000,2));
        tickets2.add(new Ticket(3,2000,2));
        tickets3.add(new Ticket(1,2000,3));
        tickets3.add(new Ticket(2,2000,3));
        tickets3.add(new Ticket(3,2000,3));

    }

    public void setMovies() {
        setTickets();
        movies.add(new Movie(1, "Inception", tickets1, "Sci-Fi", 148));
        movies.add(new Movie(2, "The Dark Knight", tickets2, "Action", 152));
        movies.add(new Movie(3, "Interstellar", tickets3, "Sci-Fi", 169));
    }

    public List<Movie> getMovies() {
        setMovies();
        return movies;
    }
}
