package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.model.Move;
import com.github.bazingaZ.silverscreenticket.model.Ticket;

import java.util.List;

public class BuyTicket {
    private final List<Move> moves;

    public BuyTicket(List<Move> moves) {
        this.moves = moves;
    }

    public void add(List<Ticket> ticket, int moveId) {
        Move move = moves.get(moveId);
        move.setTickets(ticket);
    }
}
