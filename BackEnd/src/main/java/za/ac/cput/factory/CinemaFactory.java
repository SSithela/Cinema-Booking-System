package za.ac.cput.factory;

import za.ac.cput.domain.Cinema;
import za.ac.cput.domain.MovieRoom;

import java.util.List;

public class CinemaFactory {
    public static Cinema createCinema(int id, List<MovieRoom> movieRooms) {

        return new Cinema.Builder()
                .setCinemaId(id)
                .setMovieRooms(movieRooms)
                .build();
    }
    public static Cinema createCinema(List<MovieRoom> movieRooms) {

        return new Cinema.Builder()
                .setMovieRooms(movieRooms)
                .build();
    }
}
