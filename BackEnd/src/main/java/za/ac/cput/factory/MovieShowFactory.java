package za.ac.cput.factory;
import za.ac.cput.domain.Movie;
import za.ac.cput.domain.MovieRoom;
import za.ac.cput.domain.MovieShow;

import java.sql.Date;


public class MovieShowFactory {
 public static MovieShow createShow(int id, Movie movie,MovieRoom room,Date dateCreated,String startTime){

     return new MovieShow.Builder()
             .setShowId(id)
             .setMovie(movie)
             .setMovieRoom(room)
             .setDateCreated(dateCreated)
             .setStartTime(startTime)
             .build();
 }
    public static MovieShow createShow(Movie movie,MovieRoom room,Date dateCreated,String startTime){

        return new MovieShow.Builder()
                .setMovie(movie)
                .setMovieRoom(room)
                .setDateCreated(dateCreated)
                .setStartTime(startTime)
                .build();
    }
}
