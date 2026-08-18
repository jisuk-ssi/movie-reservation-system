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

    //setter 및 getter

    public void setScreeningId(int screeningId) {}

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setTheater(String theater) {
        this.theater = theater;
    }

    public void setRemainingSeats(int remainingSeats) {
        this.remainingSeats = remainingSeats;
    }

    public int getScreeningId() {
        return screeningId;
    }

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

    @Override
    public String toString() {
        return "Screen [screeningId=" + screeningId +
                ", movie=" + movie.getMovieName() +
                ", start time=" + startTime +
                ", theater"  + theater +
                ", remainingSeats=" + remainingSeats + "]";
    }
}
