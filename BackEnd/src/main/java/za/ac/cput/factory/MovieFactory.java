package za.ac.cput.factory;

import za.ac.cput.domain.Genre;
import za.ac.cput.domain.Movie;

import java.util.List;

public class MovieFactory {
    public static Movie createMovie(String movie_id, String title, String overview, String posterImg, String backdropImg,String releaseDate,double ratting, List<Genre> genres,boolean nowShowing) {
        //Come back to fix conditions
        return new Movie.Builder().setMovie_id(movie_id)
                .setTitle(title)
                .setNowShowing(nowShowing)
                .setOverview(overview)
                .setPosterImg(posterImg)
                .setBackdropImg(backdropImg)
                .setGenres(genres)
                .setReleaseDate(releaseDate)
                .setRatting(ratting)
                .build();
    }
}
