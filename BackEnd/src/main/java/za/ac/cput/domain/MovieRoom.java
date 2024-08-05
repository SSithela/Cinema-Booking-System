package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class MovieRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private  int room_id;
    private int roomNum;
    private boolean available;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_room_id",referencedColumnName = "room_id")
    private List<Seat> seats=new ArrayList<>();
    protected MovieRoom() {
    }

    private MovieRoom(Builder builder) {
        this.roomNum = builder.roomNum;
        this.available = builder.available;
        this.seats = builder.seats;
        this.room_id=builder.roomId;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public boolean isAvailable() {
        return available;
    }

    public List<Seat> getSeats() {
        return seats;
    }


//    public int getRoomId() {
//        return room_id;
//    }


    public int getRoom_id() {
        return room_id;
    }

    @Override
    public String toString() {
        return "MovieRoom{" +
                "room_id=" + room_id +
                ", roomNum=" + roomNum +
                ", available=" + available +
                ", seats=" + seats +
                '}';
    }

    public static class Builder {
        private int roomId;
        private int roomNum;
        private boolean available;
        private List<Seat> seats;

        public Builder setRoomNum(int roomNum) {
            this.roomNum = roomNum;
            return this;
        }

        public Builder setAvailable(boolean available) {
            this.available = available;
            return this;
        }

        public Builder setSeats(List<Seat> seats) {
            this.seats = seats;
            return this;
        }

        public Builder setRoomId(int roomId) {
            this.roomId = roomId;
            return this;
        }

        public Builder copy(MovieRoom movieRoom) {
            this.roomNum = movieRoom.roomNum;
            this.available = movieRoom.available;
            this.seats = movieRoom.seats;
            this.roomId=movieRoom.room_id;
            return this;
        }

        public MovieRoom build() {
            return new MovieRoom(this);
        }
    }
}
