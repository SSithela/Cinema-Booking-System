package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @Column(name = "movie_id")
    private String movie_id;
    private String title;
    @Column(length = 8000)
    private String overview;
    private String posterImg;
    private String backdropImg;
    private String releaseDate;
    private double ratting;
    private boolean nowShowing;
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Genre> genres=new ArrayList<>();

//    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<MovieShow> shows;
    protected Movie(){}
    private Movie(Builder builder){
        this.movie_id = builder.movie_id;
        this.title = builder.title;
        this.overview = builder.overview;
        this.posterImg = builder.posterImg;
        this.backdropImg = builder.backdropImg;
        this.releaseDate=builder.releaseDate;
        this.genres = builder.genres;
        this.ratting=builder.ratting;
        this.nowShowing= builder.nowShowing;
    }

    public String getMovie_id() {
        return movie_id;
    }

    public boolean isNowShowing() {
        return nowShowing;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getOverview() {
        return overview;
    }

    public String getPosterImg() {
        return posterImg;
    }

    public String getBackdropImg() {
        return backdropImg;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public double getRatting() {
        return ratting;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movie_id='" + movie_id + '\'' +
                ", title='" + title + '\'' +
                ", overview='" + overview + '\'' +
                ", posterImg='" + posterImg + '\'' +
                ", backdropImg='" + backdropImg + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", ratting=" + ratting +
                ", nowShowing=" + nowShowing +
                ", genres=" + genres +
                '}';
    }

    public static class Builder {
        private String movie_id;
        private String title;
        private String overview;
        private String posterImg;
        private String backdropImg;
        private String releaseDate;
        private double ratting;
        private  boolean nowShowing;
        private List<Genre> genres=new ArrayList<>();

        public Builder setNowShowing(boolean nowShowing) {
            this.nowShowing = nowShowing;
            return this;
        }

        public Builder setMovie_id(String movie_id) {
            this.movie_id = movie_id;
            return this;
        }

        public Builder setRatting(double ratting) {
            this.ratting = ratting;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setOverview(String overview) {
            this.overview = overview;
            return this;
        }

        public Builder setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public Builder setPosterImg(String posterImg) {
            this.posterImg = posterImg;
            return this;
        }

        public Builder setBackdropImg(String backdropImg) {
            this.backdropImg = backdropImg;
            return this;
        }

        public Builder setGenres(List<Genre> genres) {
            this.genres = genres;
            return this;
        }

        public Builder copy(Movie movie) {
            this.movie_id = movie.movie_id;
            this.title = movie.title;
            this.overview = movie.overview;
            this.posterImg = movie.posterImg;
            this.backdropImg = movie.backdropImg;
            this.genres = movie.genres;
            this.releaseDate=movie.releaseDate;
            return this;
        }
        public Movie build(){
            return new Movie(this);
        }
    }

}
