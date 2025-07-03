package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static final SessionFactory sessionFactory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(Movie.class)
            .addAnnotatedClass(Ticket.class)
            .buildSessionFactory();

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    //TODO
    // imp with singleton pattern
}
