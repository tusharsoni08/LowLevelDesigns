package org.moviebookingdesign;

import java.util.concurrent.atomic.AtomicInteger;

class Theater {
    String theaterId;
    String theaterName;
    String location;

    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    public Theater(String theaterName, String location) {
        this.theaterId = "theater-" + ID_COUNTER.incrementAndGet();
        this.theaterName = theaterName;
        this.location = location;
    }
}
