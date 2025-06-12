package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.util.List;

public class CinemaHibernateImp implements Cinema{

    @Override
    public void addMovie(Movie movie) {
       Session session = HibernateUtil.getSession();
       session.beginTransaction();
       session.persist(movie);
       session.getTransaction().commit();
       session.close();
    }

    @Override
    public Movie getMovie(int id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Movie movie = session.get(Movie.class, id);
        Hibernate.initialize(movie.getTickets());
        session.getTransaction().commit();
        session.close();
        return movie;
    }

    @Override
    public boolean existMovie(Movie movie) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Movie foundMovie = session.get(Movie.class, movie.getId());
        session.getTransaction().commit();
        session.close();
        if (foundMovie.equals(movie)) {
            return true;
        }
        return false;
    }

    @Override
    public List<Ticket> getTickets(int movieId) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Movie movie = session.get(Movie.class, movieId);
        Hibernate.initialize(movie.getTickets());
        session.getTransaction();
        session.close();
        return movie.getTickets();
    }

    public void addTicket(Ticket ticket) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(ticket);
        session.getTransaction().commit();
        session.close();
    }
}
