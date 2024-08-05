package za.ac.cput.domain;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class MovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int showId;
    @ManyToOne
    @JoinColumn(name = "room_id")
    private MovieRoom movieRoom;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
    private Date dateCreated;
    private String startTime;


    protected MovieShow(){}
    private MovieShow(Builder builder){
        this.showId = builder.showId;
        this.movieRoom = builder.movieRoom;
        this.movie = builder.movie;
        this.dateCreated = builder.dateCreated;
        this.startTime = builder.startTime;
    }

    public int getShowId() {
        return showId;
    }

    public MovieRoom getRoom() {
        return movieRoom;
    }

    public Movie getMovie() {
        return movie;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public String getStartTime() {
        return startTime;
    }


    public MovieRoom getMovieRoom() {
        return movieRoom;
    }

    @Override
    public String toString() {
        return "MovieShow{" +
                "showId=" + showId +
                ", movieRoom=" + movieRoom +
                ", movie=" + movie +
                ", dateCreated=" + dateCreated +
                ", startTime='" + startTime + '\'' +
                '}';
    }

    public static class Builder {
        private int showId;
        private MovieRoom movieRoom;
        private Movie movie;
        private Date dateCreated;
        private String startTime;

        public Builder setShowId(Integer showId) {
            this.showId = showId;
            return this;
        }
        public Builder setMovieRoom(MovieRoom movieRoom) {
            this.movieRoom = movieRoom;
            return this;
        }
        public Builder setMovie(Movie movie) {
            this.movie = movie;
            return this;
        }
        public Builder setDateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }
        public Builder setStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }
        public Builder copy(MovieShow show) {
            this.showId = show.showId;
            this.movieRoom = show.movieRoom;
            this.movie = show.movie;
            this.dateCreated= show.dateCreated;
            this.startTime = show.startTime;
            return this;
        }
        public MovieShow build(){
            return new MovieShow(this);
        }
    }
}
