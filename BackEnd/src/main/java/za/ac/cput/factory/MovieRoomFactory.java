package za.ac.cput.factory;

import za.ac.cput.domain.Cinema;
import za.ac.cput.domain.MovieRoom;
import za.ac.cput.domain.Seat;

import java.util.List;

public class MovieRoomFactory {
    public static MovieRoom createRoom(int roomNum,boolean available, List<Seat> seats) {
        return new MovieRoom.Builder()
                .setAvailable(available)
                .setSeats(seats)
                .setRoomNum(roomNum)
                .build();
    }

    public static MovieRoom createRoom(int id,int roomNum,boolean available, List<Seat> seats) {
        return new MovieRoom.Builder()
                .setRoomId(id)
                .setRoomNum(roomNum)
                .setAvailable(available)
                .setSeats(seats)
                .build();
    }
}
