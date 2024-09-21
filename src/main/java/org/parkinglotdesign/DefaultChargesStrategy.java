package org.parkinglotdesign;

public class DefaultChargesStrategy implements ParkingChargesStrategy{
    @Override
    public double calculatePrice(long parkingHours) {
        return 5*parkingHours;
    }
}
