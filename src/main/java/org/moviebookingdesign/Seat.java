package org.moviebookingdesign;

import lombok.Getter;

@Getter
class Seat {
    String seatNumber;
    SeatType seatType;
    boolean isFree;
    User user;
    double price;

    Seat(String seatNumber, SeatType seatType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.isFree = true;
        this.user = null;
        if (SeatType.VIP.equals(seatType)) {
            this.price = 1000.0;
        } else {
            this.price = 500.0;
        }
    }

    public void assignSeat(User user) {
        this.user = user;
        this.isFree = false;
    }

    public void setFree() {
        this.user = null;
        this.isFree = true;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", seatType=" + seatType +
                ", isFree=" + isFree +
                ", user=" + user +
                ", price=" + price +
                '}';
    }
}
