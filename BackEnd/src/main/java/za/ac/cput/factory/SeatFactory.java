package za.ac.cput.factory;

import za.ac.cput.domain.MovieRoom;
import za.ac.cput.domain.Seat;

public class SeatFactory {
    public static Seat createSeat(int seatNum, double price, boolean reserved) {

        return new Seat.Builder()
                .setSeatNum(seatNum)
                .setPrice(price)
                .setReserved(reserved)
                .build();
    }
    public static Seat createSeat(int id,int seatNum, double price, boolean reserved) {

        return new Seat.Builder().setSeatId(id)
                .setSeatNum(seatNum)
                .setPrice(price)
                .setReserved(reserved)
                .build();
    }
}
