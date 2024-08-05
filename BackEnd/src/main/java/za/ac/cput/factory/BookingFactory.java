package za.ac.cput.factory;
import za.ac.cput.domain.Booking;
import za.ac.cput.domain.MovieShow;
import za.ac.cput.domain.Seat;

import java.util.Date;
import java.util.List;

public class BookingFactory {
    public static Booking createBooking(Date dateMade, List<Seat> seatNum, MovieShow movieShow) {
        return new Booking.Builder()
                .setMovieShow(movieShow)
                .setDateMade(dateMade)
                .setSeats(seatNum)
                .build();
    }
    public static Booking createBooking(int id,Date dateMade, List<Seat> seatNum, MovieShow movieShow) {
        return new Booking.Builder()
                .setBookingId(id)
                .setMovieShow(movieShow)
                .setDateMade(dateMade)
                .setSeats(seatNum)
                .build();
    }


}
