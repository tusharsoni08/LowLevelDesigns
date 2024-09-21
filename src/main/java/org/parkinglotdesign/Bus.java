package org.parkinglotdesign;

public class Bus extends Vehicle {
    public Bus(String licensePlateNo, VehicleType vehicleType) {
        super(licensePlateNo, vehicleType);
    }

    public VehicleType getType() {
        return VehicleType.BUS;
    }


}
