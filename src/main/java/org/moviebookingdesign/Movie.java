package org.moviebookingdesign;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
class Movie {
    String movieId;
    String title;
    String casts;
    String director;
    String genre;
    @Getter
    List<Show> shows;

    private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);

    public Movie(String title, String casts, String director, String genre) {
        this.movieId = "movie-" + ID_COUNTER.incrementAndGet();
        this.title = title;
        this.casts = casts;
        this.director = director;
        this.genre = genre;
        this.shows = new ArrayList<>();
    }

    public void addShow(Show show) {
        shows.add(show);
    }
}
