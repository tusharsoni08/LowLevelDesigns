package org.moviebookingdesign;

import java.util.List;

interface BookingChargesStrategy {
    double calculate(List<Seat> seats);
}
