package com.holic.moviereservationsystem.model;

import java.time.LocalDateTime;

public class Screening {

    private int screeningId;
    private Movie movie;
    private LocalDateTime startTime;
    private String theater;

    public Screening(int screeningId, Movie movie, LocalDateTime startTime, String theater) {

        this.screeningId = screeningId;
        this.movie = movie;
        this.startTime = startTime;
        this.theater = theater;
    }
}
