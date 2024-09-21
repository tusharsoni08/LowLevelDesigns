package org.moviebookingdesign;

import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
class Ticket {
    public String ticketId;
    private Show show;
    private List<Seat> seats;
    private User user;
    private Date bookingDate;
    private double price;

    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    private Ticket(Builder builder) {
        this.ticketId = "ticket-" + ID_COUNTER.incrementAndGet();
        this.show = builder.show;
        this.seats = builder.seats;
        this.user = builder.user;
        this.bookingDate = new Date();
        this.price = builder.price;
    }

    public static class Builder {
        Show show;
        List<Seat> seats;
        User user;
        double price;

        public Builder setShow(Show show) {
            this.show = show;
            return this;
        }

        public Builder setSeats(List<Seat> seats) {
            this.seats = seats;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", show=" + show +
                ", seats=" + seats +
                ", user=" + user +
                ", bookingDate=" + bookingDate +
                ", price=" + price +
                '}';
    }
}
