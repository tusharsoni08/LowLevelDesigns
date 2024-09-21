package org.parkinglotdesign;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ParkingLot parkingLot = ParkingLot.getInstance(2,1);

        Vehicle bus = new Bus("123", VehicleType.BUS);
        Ticket ticket = parkingLot.park(bus);
        System.out.println("Ticket: " + ticket.toString());
        double parkingFee = parkingLot.unpark(ticket);
        System.out.println("Parking Fee: " + parkingFee);

        Vehicle bike = new Bike("234", VehicleType.BIKE);
        Ticket ticket1 = parkingLot.park(bike);
        System.out.println("Ticket: " + ticket1.toString());
        double parkingFee1 = parkingLot.unpark(ticket1);
        System.out.println("Parking Fee: " + parkingFee1);

        Vehicle bike2 = new Bike("584", VehicleType.BIKE);
        Ticket ticket2 = parkingLot.park(bike2);
        System.out.println("Ticket: " + ticket2.toString());
        double parkingFee2 = parkingLot.unpark(ticket2);
        System.out.println("Parking Fee: " + parkingFee2);

        Vehicle bike3 = new Bike("923", VehicleType.BIKE);
        Ticket ticket3 = parkingLot.park(bike3);
        System.out.println("Ticket: " + ticket3.toString());
        double parkingFee3 = parkingLot.unpark(ticket3);
        System.out.println("Parking Fee: " + parkingFee3);
    }
}

/*

Approach OO Design
	--	handle ambiguity
		- OOD questions are often intentionally vague in order to test whether you'll make assumptions or if you'll ask clarifying questions.
		- When being asked an OOD question, you should inquire who is going to use it and how they are going to use it. Who, What, Where, When, How, Why
	--	define the core object
	--	analyze relationships
		- analyze the relationships between the objects
		  which objects are members of which other objects
		  do any objects inherit from any others
		  are relationships many-to-many or one-to-many
	--	investigate actions
		consider the key actions that the objects will take and how they relate to each other(update your design)

Core Entities:
- ParkingLot
- ParkingFloor
- ParkingSpot
- Vehicle (LARGE, SMALL)
- Ticket
- Payment

 */


