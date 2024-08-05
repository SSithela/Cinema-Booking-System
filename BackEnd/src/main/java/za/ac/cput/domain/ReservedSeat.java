package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class ReservedSeat {
    @EmbeddedId
    private ReservedSeatId reservedSeatId;

    protected ReservedSeat() {

    }

    private ReservedSeat(Builder builder) {
        this.reservedSeatId = builder.reservedSeatId;
    }

    public ReservedSeatId getReservedSeatId() {
        return reservedSeatId;
    }

    @Override
    public String toString() {
        return "ReservedSeat{" +
                "reservedSeatId=" + reservedSeatId +
                '}';
    }

    public static class Builder {
        private ReservedSeatId reservedSeatId;

        public Builder setReservedSeatId(ReservedSeatId reservedSeatId) {
            this.reservedSeatId = reservedSeatId;
            return this;
        }

        public ReservedSeat build() {
            return new ReservedSeat(this);
        }
    }
}
