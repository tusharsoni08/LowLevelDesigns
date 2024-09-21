package org.parkinglotdesign;

import lombok.Getter;

import java.util.UUID;

@Getter
public class ParkingSpot {
    String spotId;
    Vehicle vehicle;
    boolean isFree;
    ParkingSpotType parkingSpotType;

    public ParkingSpot(ParkingSpotType parkingSpotType) {
        this.isFree = true;
        this.parkingSpotType = parkingSpotType;
        this.spotId = UUID.randomUUID().toString();
    }

    public boolean isFree() {
        return isFree;
    }

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isFree = false;
    }

    public void unpark(Vehicle vehicle) {
        this.vehicle = null;
        this.isFree = true;
    }

}
