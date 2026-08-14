package com.holic.moviereservationsystem.model;

public class Movie {

    private int movieID;
    private String movieName;
    private Genre genre;
    private int runningTime;

    public Movie(int movieID, String movieName, Genre genre, int runningTime) {

        this.movieID = movieID;
        this.movieName = movieName;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    public int getMovieID() {
        return movieID;
    }

    public String getMovieName() {
        return movieName;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getRunningTime() {
        return runningTime;
    }
}
