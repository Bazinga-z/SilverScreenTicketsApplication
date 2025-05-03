package com.github.bazingaZ.silverscreenticket.model;

public class Ticket {
    private final int id;
    private final int price;
    private final int moveId;

    public Ticket(int id, int price, int moveId) {
        this.id = id;
        this.price = price;
        this.moveId = moveId;
    }

    public int getPrice() {
        return price;
    }
}
