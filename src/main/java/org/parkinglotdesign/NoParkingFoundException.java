package org.parkinglotdesign;

public class NoParkingFoundException extends RuntimeException {
    public NoParkingFoundException(String message) {
        super(message);
    }
}
