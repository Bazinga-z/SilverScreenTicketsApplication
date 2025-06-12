package com.github.bazingaZ.silverscreenticket.model;

import jakarta.persistence.*;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int price;
    private int moveId;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public Ticket(int id, int price, int moveId) {
        this.id = id;
        this.price = price;
        this.moveId = moveId;
    }

    public Ticket(int price, Movie movie) {
        this.price = price;
        this.movie = movie;
    }

    public Ticket(int price, int moveId) {
        this.price = price;
        this.moveId = moveId;
    }

    public Ticket() {

    }

    public int getMoveId() {
        return moveId;
    }

    public int getPrice() {
        return price;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public Movie getMovie() { return movie ;}

    public void setMovie(Movie movie) { this.movie = movie; }
}
