package org.parkinglotdesign;

import lombok.Getter;

public abstract class Vehicle {
    @Getter
    String licensePlateNo;
    VehicleType vehicleType;

    public Vehicle(String licensePlateNo, VehicleType vehicleType) {
        this.licensePlateNo = licensePlateNo;
        this.vehicleType = vehicleType;
    }

    public abstract VehicleType getType();

}
