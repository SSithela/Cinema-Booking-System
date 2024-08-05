package za.ac.cput.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Embeddable
public class ReservedSeatId implements Serializable {
    @ManyToOne
    private MovieShow movieShow;
    @ManyToOne
    private Seat seat;

    protected ReservedSeatId() {
    }
    public ReservedSeatId(MovieShow movieShow, Seat seat) {
        this.movieShow = movieShow;
        this.seat = seat;
    }

    public MovieShow getMovieShow() {
        return movieShow;
    }

    public Seat getSeat() {
        return seat;
    }

    public ReservedSeatId setMovieShow(MovieShow movieShow) {
        this.movieShow = movieShow;
        return this;
    }

    public ReservedSeatId setSeat(Seat seat) {
        this.seat = seat;
        return this;
    }

    @Override
    public String toString() {
        return "ReservedSeatId{" +
                "movieShow=" + movieShow +
                ", seat=" + seat +
                '}';
    }
}
