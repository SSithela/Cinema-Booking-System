package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingId;
    @ManyToOne
    private MovieShow movieShow;
    private Date dateMade;
    @OneToMany
    private List<Seat> seats;

    protected Booking() {
    }

    private Booking(Builder builder) {
        this.bookingId = builder.bookingId;
        this.movieShow = builder.movieShow;
        this.dateMade = builder.dateMade;
        this.seats = builder.seats;
    }

    public int getBookingId() {
        return bookingId;
    }


    public MovieShow getMovieShow() {
        return movieShow;
    }

    public Date getDateMade() {
        return dateMade;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", movieShow=" + movieShow +
                ", dateMade=" + dateMade +
                ", seats=" + seats +
                '}';
    }

    public static class Builder {
        private int bookingId;
        private MovieShow movieShow;
        private Date dateMade;
        private List<Seat> seats;

        public Builder setBookingId(int bookingId) {
            this.bookingId = bookingId;
            return this;
        }


        public Builder setMovieShow(MovieShow movieShow) {
            this.movieShow = movieShow;
            return this;
        }

        public Builder setDateMade(Date dateMade) {
            this.dateMade = dateMade;
            return this;
        }

        public Builder setSeats(List<Seat> seatNum) {
            this.seats = seatNum;
            return this;
        }

        public Builder copy(Booking booking) {
            this.bookingId = booking.bookingId;
            this.movieShow = booking.movieShow;
            this.dateMade = booking.dateMade;
            this.seats = booking.seats;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}
