package com.github.bazingaZ.silverscreenticket.usecase;

import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;

import java.util.List;

public interface Cinema {

    void addMovie(Movie movie);

    Movie getMove(int id);

    boolean existMove(Movie movie);
    // todo add new method if need

    List<Ticket> getTickets(int movieId);

}
