package com.github.bazingaZ.silverscreenticket.logic;

import org.junit.jupiter.api.Test;

class TicketServiceTest {
    @Test
    void shouldCreateTicketForExistingMovie() {
        // Check if movie exists, otherwise throw an exception.
        // If found, add a ticket with a validated price.
    }

    @Test
    void shouldNotAllowedBuyingTicketForNonExistentMovie() {
        // Find the movie; if no tickets exist, throw a custom exception.
    }

    @Test
    void shouldReduceAvailableTicketsWhenPurchasing() {
        // Find the movie and get available tickets.
        // Deduct the number of tickets requested by the user.
        // Calculate the total price and complete the transaction if valid.
    }

    @Test
    void shouldPreventPurchaseWhenInsufficientFunds() {
        // Calculate total price and throw a custom exception if funds are insufficient.
    }


}