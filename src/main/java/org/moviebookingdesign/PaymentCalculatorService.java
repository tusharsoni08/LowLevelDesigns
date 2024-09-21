package org.moviebookingdesign;

import java.util.List;

class PaymentCalculatorService {
    BookingChargesStrategy bookingChargesStrategy;

    public PaymentCalculatorService(BookingChargesStrategy bookingChargesStrategy) {
        this.bookingChargesStrategy = bookingChargesStrategy;
    }

    public double calculateAmount(List<Seat> seats) {
        return bookingChargesStrategy.calculate(seats);
    }

    public void setBookingChargesStrategy(BookingChargesStrategy bookingChargesStrategy) {
        this.bookingChargesStrategy = bookingChargesStrategy;
    }
}
