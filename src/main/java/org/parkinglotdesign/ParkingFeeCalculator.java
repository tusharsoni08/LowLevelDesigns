package org.parkinglotdesign;

public class ParkingFeeCalculator {
    ParkingChargesStrategy parkingChargesStrategy;

    public ParkingFeeCalculator(ParkingChargesStrategy parkingChargesStrategy) {
        this.parkingChargesStrategy = parkingChargesStrategy;
    }

    public double calculateFee(long duration) {
        return parkingChargesStrategy.calculatePrice(duration);
    }

    public void setParkingChargesStrategy(ParkingChargesStrategy parkingChargesStrategy) {
        this.parkingChargesStrategy = parkingChargesStrategy;
    }
}
