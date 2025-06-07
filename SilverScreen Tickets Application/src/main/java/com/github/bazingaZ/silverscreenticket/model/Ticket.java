package com.github.bazingaZ.silverscreenticket.model;

public class Ticket {

    private int id;
    private int price;
    private int moveId;

    public Ticket(int id, int price, int moveId) {
        this.id = id;
        this.price = price;
        this.moveId = moveId;
    }

    public Ticket(int price, int moveId) {
        this.price = price;
        this.moveId = moveId;
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
}
