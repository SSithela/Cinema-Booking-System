package za.ac.cput.factory;

import za.ac.cput.domain.MovieShow;
import za.ac.cput.domain.ReservedSeat;
import za.ac.cput.domain.ReservedSeatId;
import za.ac.cput.domain.Seat;

public class ReservedSeatFactory {
    public static ReservedSeat create(MovieShow movieShow, Seat seat){
        return new ReservedSeat.Builder()
                .setReservedSeatId(new ReservedSeatId(movieShow,seat))
                .build();
    }
}
