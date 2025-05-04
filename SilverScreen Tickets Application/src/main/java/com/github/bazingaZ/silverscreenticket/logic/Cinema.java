package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;

import java.util.List;

public interface Cinema {

    void addMovie(Movie movie);

    Movie getMovie(int id);

    boolean existMovie(Movie movie);

    List<Ticket> getTickets(int movieId);
}
