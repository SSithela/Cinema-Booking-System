package za.ac.cput.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seatId;
    private int seatNum;
//    private boolean isReserved;
    private double price;

    protected Seat() {
    }

    public Seat(Builder builder) {
        this.seatId=builder.seatId;
        this.seatNum= builder.seatNum;
//        this.isReserved= builder.isReserved;
        this.price= builder.price;
    }

    public int getSeatNum() {
        return seatNum;
    }

//    public boolean isReserved() {
//        return isReserved;
//    }

    public double getPrice() {
        return price;
    }

    public int getSeatId() {
        return seatId;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatId=" + seatId +
                ", seatNum=" + seatNum +
//                ", isReserved=" + isReserved +
                ", price=" + price +
                '}';
    }

    public static class Builder{
        private int seatId;
        private int seatNum;
        private boolean isReserved;
        private double price;

        public Builder setSeatNum(int seatNum) {
            this.seatNum = seatNum;
            return this;
        }

        public Builder setReserved(boolean reserved) {
            this.isReserved = reserved;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder setSeatId(int seatId) {
            this.seatId = seatId;
            return this;
        }
        public Builder copy(Seat seat){
            this.seatNum=seat.seatNum;
            this.price=seat.price;
//            this.isReserved=seat.isReserved;
            this.seatId=seat.seatId;
            return this;
        }
        public Seat build(){
            return new Seat(this);
        }
    }
}
