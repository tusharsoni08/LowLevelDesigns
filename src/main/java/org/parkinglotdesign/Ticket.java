package org.parkinglotdesign;

import lombok.Getter;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Getter
public class Ticket {
    String ticketId;
    String licensePlateNo;
    String parkingFloorNumber;
    Date date;

    public Ticket(String licensePlateNo, String parkingFloorNumber) {
        this.licensePlateNo = licensePlateNo;
        this.parkingFloorNumber = parkingFloorNumber;
        this.ticketId = UUID.randomUUID().toString();
        this.date = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket ticket)) return false;
        return Objects.equals(ticketId, ticket.ticketId) && Objects.equals(licensePlateNo, ticket.licensePlateNo) && Objects.equals(date, ticket.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ticketId, licensePlateNo, date);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId='" + ticketId + '\'' +
                ", licensePlateNo='" + licensePlateNo + '\'' +
                ", parkingFloorNumber='" + parkingFloorNumber + '\'' +
                ", date=" + date +
                '}';
    }
}
