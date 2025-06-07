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
        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                return movie;
            }
        }
        throw new MovieNotFound("No Movie With That Id Exists");
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
//package com.github.bazingaZ.silverscreenticket.logic;
//
//        import com.github.bazingaZ.silverscreenticket.exception.MovieNotFound;
//        import com.github.bazingaZ.silverscreenticket.model.Movie;
//        import com.github.bazingaZ.silverscreenticket.model.Ticket;
//
//        import java.sql.*;
//        import java.util.ArrayList;
//        import java.util.List;
//
//public class CinemaJDBCImp implements Cinema {
//
//    private final String URL = "jdbc:postgresql://localhost:5432/cinematicket";
//    private final String USER = "your_username";
//    private final String PASSWORD = "your_password";
//
//    @Override
//    public void addMovie(Movie movie) {
//        String sql = "INSERT INTO movies (name, genre, duration, countOfTickets) VALUES (?, ?, ?, ?)";
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
//
//            pstmt.setString(1, movie.getName());
//            pstmt.setString(2, movie.getGenre());
//            pstmt.setInt(3, movie.getDuration());
//            pstmt.setInt(4, movie.getCountOfTickets());
//            pstmt.executeUpdate();
//
//            try (ResultSet rs = pstmt.getGeneratedKeys()) {
//                if (rs.next()) {
//                    movie.setId(rs.getInt(1)); // Assign generated ID to movie
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public Movie getMovie(int movieId) {
//        String sql = "SELECT * FROM movies WHERE id = ?";
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setInt(1, movieId);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    return new Movie(
//                            rs.getInt("id"),
//                            rs.getString("name"),
//                            rs.getString("genre"),
//                            rs.getInt("duration"),
//                            rs.getInt("countOfTickets"),
//                            getTickets(movieId) // Fetch associated tickets
//                    );
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        throw new MovieNotFound("No Movie With That Id Exists");
//    }
//
//    @Override
//    public boolean existMovie(Movie movie) {
//        String sql = "SELECT COUNT(*) FROM movies WHERE id = ?";
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setInt(1, movie.getId());
//            try (ResultSet rs = pstmt.executeQuery()) {
//                if (rs.next()) {
//                    return rs.getInt(1) > 0;
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public List<Ticket> getTickets(int movieId) {
//        List<Ticket> tickets = new ArrayList<>();
//        String sql = "SELECT * FROM tickets WHERE movieId = ?";
//        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//             PreparedStatement pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setInt(1, movieId);
//            try (ResultSet rs = pstmt.executeQuery()) {
//                while (rs.next()) {
//                    tickets.add(new Ticket(
//                            rs.getInt("id"),
//                            rs.getInt("price"),
//                            rs.getInt("movieId")
//                    ));
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return tickets;
//    }
//}

