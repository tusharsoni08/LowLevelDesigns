package org.parkinglotdesign;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloor {
    @Getter
    String floorNumber;
    Map<ParkingSpotType, Map<String, ParkingSpot>> parkingSpotsMapByTypes;

    public ParkingFloor(String floorNumber) {
        this.parkingSpotsMapByTypes = new HashMap<>();
        this.floorNumber = floorNumber;
    }

    public void addParkingSpot(ParkingSpot parkingSpot) {
        if (!parkingSpotsMapByTypes.containsKey(parkingSpot.getParkingSpotType())) {
            parkingSpotsMapByTypes.put(parkingSpot.getParkingSpotType(), new HashMap<>());
        }
        parkingSpotsMapByTypes
                .get(parkingSpot.getParkingSpotType())
                .put(parkingSpot.getSpotId(), parkingSpot);
    }

    public ParkingSpot getAvailableParkingSpot(ParkingSpotType parkingSpotType) {
        if (!parkingSpotsMapByTypes.containsKey(parkingSpotType)) {
            System.out.println("No parking spots found for type " + parkingSpotType);
            return null;
        }
        for (ParkingSpot parkingSpot : parkingSpotsMapByTypes.get(parkingSpotType).values()) {
            if (parkingSpot.isFree()) {
                return parkingSpot;
            }
        }
        return null;
    }

    public void freeUpParkingSpot(ParkingSpot parkingSpot) {
        ParkingSpot parkedSpot = parkingSpotsMapByTypes.get(parkingSpot.getParkingSpotType()).get(parkingSpot.getSpotId());
        parkedSpot.unpark(parkingSpot.getVehicle());
    }
}
