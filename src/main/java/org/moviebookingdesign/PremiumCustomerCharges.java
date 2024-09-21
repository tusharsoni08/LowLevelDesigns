package org.moviebookingdesign;

import java.util.List;

public class PremiumCustomerCharges implements BookingChargesStrategy {
    private static final double platformFee = 10;

    @Override
    public double calculate(List<Seat> seats) {
        return platformFee + seats.stream().mapToDouble(Seat::getPrice).sum();
    }
}
