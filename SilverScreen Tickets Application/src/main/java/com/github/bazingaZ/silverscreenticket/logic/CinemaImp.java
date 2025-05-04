package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.exception.MovieNotFound;
import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;

import java.util.List;

public class CinemaImp implements Cinema {

    private final List<Movie> movies;

    public CinemaImp(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    @Override
    public Movie getMovie(int movieId) {
        try {
            return movies.get(movieId);
        } catch (Exception exception) {
            throw new MovieNotFound("No Movie With That Id Exists");
        }
    }

    @Override
    public boolean existMovie(Movie movie) {
        return movies.contains(movie);
    }

    @Override
    public List<Ticket> getTickets(int movieId) {
        Movie movie = getMovie(movieId);
        return movie.getTickets();
    }
}
