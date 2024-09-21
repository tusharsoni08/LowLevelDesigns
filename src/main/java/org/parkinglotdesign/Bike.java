package org.parkinglotdesign;

public class Bike extends Vehicle {
    public Bike(String licensePlateNo, VehicleType vehicleType) {
        super(licensePlateNo, vehicleType);
    }

    public VehicleType getType() {
        return VehicleType.BIKE;
    }
}
