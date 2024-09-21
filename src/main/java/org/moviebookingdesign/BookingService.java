package org.moviebookingdesign;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BookingService {
    private static BookingService instance;
    ConcurrentMap<String, Ticket> ticketsBooked;
    PaymentCalculatorService paymentCalculatorService;

    private BookingService() {
        this.ticketsBooked = new ConcurrentHashMap<>();
        this.paymentCalculatorService = new PaymentCalculatorService(new NormalCustomerCharges());
    }

    public static BookingService getInstance() {
        if (instance == null) {
            instance = new BookingService();
        }
        return instance;
    }

    public Ticket generateTicket(Show show, List<Seat> seats, User user) {
        try {
            show.assignSeats(seats, user);
            if (user.isPremium) {
                paymentCalculatorService.setBookingChargesStrategy(new PremiumCustomerCharges());
            }
            double amount = paymentCalculatorService.calculateAmount(seats);
            Ticket ticket = new Ticket.Builder()
                    .setSeats(seats)
                    .setUser(user)
                    .setShow(show)
                    .setPrice(amount)
                    .build();

            ticketsBooked.put(ticket.getTicketId(), ticket);

            return ticket;
        } catch (Exception e) {
            System.out.println("Error occurred while booking ticket for username: " + user.getFirstName());
            show.unassignSeats(seats, user);
        }
        return null;
    }
}
