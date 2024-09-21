package org.parkinglotdesign;

public class FourWheelerChargesStrategy implements ParkingChargesStrategy{
    public double calculatePrice(long parkingHours) {
        if (parkingHours < 1) {
            return 20;
        }
        return 20 * parkingHours;
    }
}