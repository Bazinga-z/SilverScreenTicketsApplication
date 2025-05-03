package com.github.bazingaZ.silverscreenticket.usecase;

import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;

import java.util.List;

public class CinemaImpl implements Cinema {

    private final List<Movie> movies;

    public CinemaImpl(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    @Override
    public Movie getMove(int id) {
        try {
            return movies.get(id);
        } catch (Exception e) {
            throw new MoveNotExist();
        }
    }

    @Override
    public boolean existMove(Movie movie) {
        return movies.contains(movie);
    }

    @Override
    public List<Ticket> getTickets(int movieId) {
        Movie movie = movies.get(movieId);
        return movie.getTickets();
    }


}
