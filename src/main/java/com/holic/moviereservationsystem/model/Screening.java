package com.holic.moviereservationsystem.model;

import java.time.LocalDateTime;

public class Screening {

    private int screeningId;
    private Movie movie;
    private LocalDateTime startTime;
    private String theater;
    private int remainingSeats;

    public Screening(Movie movie, LocalDateTime startTime, String theater, int remainingSeats) {

        this.movie = movie;
        this.startTime = startTime;
        this.theater = theater;
        this.remainingSeats = remainingSeats;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {}

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getTheater() {
        return theater;
    }

    public int getRemainingSeats() {
        return remainingSeats;
    }
}
