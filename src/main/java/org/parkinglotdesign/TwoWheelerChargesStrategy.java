package org.parkinglotdesign;

public class TwoWheelerChargesStrategy implements ParkingChargesStrategy {
    public double calculatePrice(long parkingHours) {
        if (parkingHours < 1) {
            return 10;
        }
        return 10 * parkingHours;
    }
}
