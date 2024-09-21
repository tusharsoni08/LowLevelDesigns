package org.parkinglotdesign;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class ParkingLot {
    private static ParkingLot parkingLot;
    SortedMap<String, ParkingFloor> parkingFloors;
    Map<Ticket, ParkingSpot> parkedSpots;
    ParkingFeeCalculator parkingFeeCalculator;

    private ParkingLot(int totalFloors, int totalSpots) {
        this.parkingFloors = new TreeMap<>();
        this.parkedSpots = new HashMap<>();
        this.parkingFeeCalculator = new ParkingFeeCalculator(new DefaultChargesStrategy());

        initializeParkingLot(totalFloors, totalSpots);
    }

    private void initializeParkingLot(int totalFloors, int totalSpots) {
        for(int i = 0; i < totalFloors; i++) {
            String floorNumber = "Floor-" + (i + 1);
            parkingFloors.put(floorNumber, new ParkingFloor(floorNumber));
            for(int j = 0; j < totalSpots; j++) {
                parkingFloors.get(floorNumber).addParkingSpot(new ParkingSpot(ParkingSpotType.LARGE));
            }
            for(int j = 0; j < totalSpots; j++) {
                parkingFloors.get(floorNumber).addParkingSpot(new ParkingSpot(ParkingSpotType.SMALL));
            }
        }
    }

    public static ParkingLot getInstance(int totalFloors, int totalSpots) {
        if (parkingLot == null) {
            parkingLot = new ParkingLot(totalFloors, totalSpots);
        }
        return parkingLot;
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingFloors.put(parkingFloor.getFloorNumber(), parkingFloor);
    }

    public Ticket park(Vehicle vehicle) throws Exception {
        ParkingSpotType parkingSpotType = getParkingSpotType(vehicle.getType());
        for (ParkingFloor parkingFloor : parkingFloors.values()) {
            ParkingSpot parkingSpot = parkingFloor.getAvailableParkingSpot(parkingSpotType);
            if(parkingSpot == null) {
                System.out.println("No parking spot found on " + parkingFloor.getFloorNumber() + ". Searching on other floors...");
                continue;
            } else {
                System.out.println("Parking spot found on " + parkingFloor.getFloorNumber() + " having spotId: " + parkingSpot.getSpotId());
            }
            Ticket ticket = new Ticket(vehicle.getLicensePlateNo(), parkingFloor.getFloorNumber());
            parkingSpot.park(vehicle);
            parkedSpots.put(ticket, parkingSpot);
            return ticket;
        }
        throw new NoParkingFoundException("Sorry! No parking spots available for vehicle " + vehicle.getLicensePlateNo());
    }

    public double unpark(Ticket ticket) {
        if(ticket == null) {
            System.out.println("Ticket not found");
            return 0;
        }
        ParkingSpot parkingSpot = parkedSpots.get(ticket);
        ParkingFloor parkingFloor = parkingFloors.get(ticket.getParkingFloorNumber());
        VehicleType vehicleType = parkingSpot.getVehicle().getType();
        parkingFloor.freeUpParkingSpot(parkingSpot);
        parkedSpots.remove(ticket);

        long parkingDuration = TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis() - ticket.getDate().getTime());
        if(vehicleType == VehicleType.BUS) {
            parkingFeeCalculator.setParkingChargesStrategy(new FourWheelerChargesStrategy());
        } else {
            parkingFeeCalculator.setParkingChargesStrategy(new TwoWheelerChargesStrategy());
        }
        return parkingFeeCalculator.calculateFee(parkingDuration);
    }

    private ParkingSpotType getParkingSpotType(VehicleType vehicleType) {
        switch (vehicleType) {
            case BIKE:
                return ParkingSpotType.SMALL;
            case BUS:
                return ParkingSpotType.LARGE;
            default:
                System.out.println("VehicleType not supported: " + vehicleType);
                return null;
        }
    }
}
