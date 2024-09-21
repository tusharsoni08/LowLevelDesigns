package org.moviebookingdesign;

import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Movie movie = new Movie("MovieName", "ActorsName", "directors", "Thrill");
        Theater theater = new Theater("Phoenix", "Bengaluru");
        User user1 = new User("12345", "UserName1", true);
        User user2 = new User("67890", "UserName2", false);
        User user3 = new User("82348", "UserName3", true);

        Seat seat1 = new Seat("Seat1", SeatType.VIP);
        Seat seat2 = new Seat("Seat2", SeatType.VIP);
        Seat seat3 = new Seat("Seat3", SeatType.VIP);
        Seat seat4 = new Seat("Seat4", SeatType.NORMAL);
        Seat seat5 = new Seat("Seat5", SeatType.NORMAL);
        List<Seat> seats = List.of(seat1, seat2, seat3, seat4, seat5);
        Show show = new Show(movie, theater, new Date(), 2*60*60*1000, seats);
        movie.addShow(show);

        BookingService bookingService = BookingService.getInstance();
        List<Seat> availableSeats = show.getAvailableSeats();
        System.out.println("Before Available Seats: " + availableSeats);

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Set<Callable<Ticket>> tasks = new HashSet<>();

        tasks.add(() -> bookingService.generateTicket(show, availableSeats.subList(1, 3), user1));
        tasks.add(() -> bookingService.generateTicket(show, availableSeats.subList(4, availableSeats.size()), user2));
        tasks.add(() -> bookingService.generateTicket(show, availableSeats.subList(0, 2), user3));

        List<Future<Ticket>> futures = executorService.invokeAll(tasks);
        futures.forEach(future -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("After Available Seats: " + show.getAvailableSeats());

        executorService.shutdown();
    }
}

/*

Core Entities:
- Movie
- Show
- Theater
- Seat
- SeatType
- User
- Ticket
- Booking
- Payment

APIs:
GET /movies - Partial<Movie>[]

GET /movies/{movieId}/shows/ -> Show[]

GET /movies/{movieId}/shows/{showId} -> Seat[]

POST /booking -> Ticket
{
    showId, seat[]
}


 */

