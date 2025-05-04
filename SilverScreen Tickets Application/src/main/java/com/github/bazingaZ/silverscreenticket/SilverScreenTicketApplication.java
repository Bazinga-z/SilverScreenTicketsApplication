package com.github.bazingaZ.silverscreenticket;

import com.github.bazingaZ.silverscreenticket.exception.InsufficientMoney;
import com.github.bazingaZ.silverscreenticket.exception.InsufficientTicket;
import com.github.bazingaZ.silverscreenticket.exception.MovieNotFound;
import com.github.bazingaZ.silverscreenticket.exception.NoTicketsLeft;
import com.github.bazingaZ.silverscreenticket.logic.BuyTicket;
import com.github.bazingaZ.silverscreenticket.logic.Cinema;
import com.github.bazingaZ.silverscreenticket.logic.CinemaImp;
import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.repository.MovieSamples;

import java.util.Scanner;

public class SilverScreenTicketApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.println("Hi. Welcome To SilverScreenTicket Application!");
                System.out.println("Please Choose The Number Of Movie You Want: ");

                MovieSamples movieSamples = new MovieSamples();
                for (Movie movie : movieSamples.getMovies()) {
                    System.out.println("** " + movie.getId() + ") " + movie);
                }

                int movieId = scanner.nextInt();
                Cinema cinema = new CinemaImp(movieSamples.getMovies());
                BuyTicket buyTicket = new BuyTicket(cinema);

                try {
                    buyTicket.getMovie(movieId);
                    System.out.println("Got it! Now Please Enter The Number Of Tickets You Want.");
                } catch (MovieNotFound exception) {
                    System.out.println("Error: " + exception.getMessage());
                    continue;

                }


                int numberOfTickets = scanner.nextInt();

                try {
                    buyTicket.checksIfThereIsEnoughTicketLeft(movieId, numberOfTickets);
                } catch (InsufficientTicket e) {
                    System.out.println("Error: " + e.getMessage());
                    continue;
                } catch (NoTicketsLeft exception) {
                    System.out.println("Error: " + exception.getMessage());
                    continue;
                }

                System.out.println("This is The Money You Need To Pay: " + buyTicket.getTotalPriceNeedToBePaidToBuyTickets(numberOfTickets, movieId));
                System.out.println("Please Type This Money and Press Enter.");
                int moneyPaidForTickets = scanner.nextInt();
                try {
                    buyTicket.buyTicket(movieId, numberOfTickets, moneyPaidForTickets);
                    System.out.println("Tickets Have Been Successfully Purchased.");
                } catch (Exception exception) {
                    System.out.println("Error: " + exception.getMessage());
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        }

    }
}
