package com.github.bazingaZ.silverscreenticket.logic;

import com.github.bazingaZ.silverscreenticket.exception.MovieNotFound;
import com.github.bazingaZ.silverscreenticket.model.Movie;
import com.github.bazingaZ.silverscreenticket.model.Ticket;
import org.postgresql.jdbc.PgConnection;

import javax.script.ScriptEngine;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CinemaJdbcImp implements Cinema {

    private static final String URL = "jdbc:postgresql://localhost:5432/silverscreenticket";
    private static final String USER = "postgres";
    private static final String PASSWORD = "LST1234lst";

    @Override
    public void addMovie(Movie movie) {
       String sql = "INSERT INTO movies (name,countOfTickets, genre, duration) VALUES (?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            System.out.println("Connecting to database...");

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, movie.getName());
            preparedStatement.setInt(2, movie.getCountOfTickets());
            preparedStatement.setString(3, movie.getGenre());
            preparedStatement.setInt(4, movie.getDuration());

            preparedStatement.executeUpdate();
            System.out.println("Executing SQL INSERT...");


            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if(resultSet.next()) {
                    movie.setId(resultSet.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Movie getMovie(int id) {
        String sql = "SELECT * FROM movies WHERE movies.id = ?";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,id);

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                if(resultSet.next()) {
                    return new Movie(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getInt("countOfTickets"),
                            resultSet.getString("genre"),
                            resultSet.getInt("duration")

                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        throw new MovieNotFound("No Movie With That Id Exists");
    }

    @Override
    public boolean existMovie(Movie movie) {
        String sql = "SELECT * FROM movies WHERE movies.name = ? " +
                "AND movies.countOfTickets = ? " +
                "AND movies.genre = ? " +
                "AND movies.duration = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, movie.getName());
            preparedStatement.setInt(2, movie.getCountOfTickets());
            preparedStatement.setString(3, movie.getGenre());
            preparedStatement.setInt(4, movie.getDuration());


            try(ResultSet resultSet = preparedStatement.executeQuery()){
               if (resultSet.next()) {
                   return true;
               }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Ticket> getTickets(int movieId) {

        String sql = "SELECT * FROM tickets WHERE tickets.movieid = ? ";

        List tickets = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, movieId);

            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    int ticketId = resultSet.getInt(1);
                    int price = resultSet.getInt(2);
                    Ticket ticket = new Ticket(ticketId,price,movieId);
                    tickets.add(ticket);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tickets;
    }


    public void addTicket(Ticket ticket) {
        String sql = "INSERT INTO tickets (price, movieid) VALUES (?, ?)";
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, ticket.getPrice());
            preparedStatement.setInt(2, ticket.getMoveId());

            preparedStatement.executeUpdate();

            try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
                if(resultSet.next()) {
                    ticket.setId(resultSet.getInt(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
