package org.moviebookingdesign;

import java.util.List;

public class NormalCustomerCharges implements BookingChargesStrategy {
    private static final double platformFee = 20;

    @Override
    public double calculate(List<Seat> seats) {
        return platformFee + seats.stream().mapToDouble(Seat::getPrice).sum();
    }
}
