package org.moviebookingdesign;

import lombok.Getter;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Getter
class Show {
    String showId;
    Movie movie;
    Theater theater;
    Date showTime;
    long duration;
    ConcurrentMap<String, Seat> seatMap;
    Lock lock = new ReentrantLock();

    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    public Show(Movie movie, Theater theater, Date showTime, long duration, List<Seat> seats) {
        this.showId = "show-" + ID_COUNTER.incrementAndGet();
        this.movie = movie;
        this.theater = theater;
        this.showTime = showTime;
        this.duration = duration;
        this.seatMap = new ConcurrentHashMap<>();
        seats.forEach(seat -> {
            seatMap.put(seat.getSeatNumber(), seat);
        });
    }

    public List<Seat> getAvailableSeats() {
        return seatMap.values().stream().filter(Seat::isFree).toList();
    }

    public void assignSeats(List<Seat> selectedSeats, User user) {
        selectedSeats.forEach(seat -> {
            lock.lock();
            if (!seat.isFree()) {
                lock.unlock();
                throw new RuntimeException("Few of the selected seats are unavailable");
            }
            seatMap.get(seat.getSeatNumber()).assignSeat(user);
            lock.unlock();
        });
    }

    public void unassignSeats(List<Seat> selectedSeats, User user) {
        selectedSeats.forEach(seat -> {
            lock.lock();
            if(seat.getUser() == user) {
                seatMap.get(seat.getSeatNumber()).setFree();
            }
            lock.unlock();
        });
    }
}
