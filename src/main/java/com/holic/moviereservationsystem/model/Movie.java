package com.holic.moviereservationsystem.model;

public class Movie {

    private int movieID;
    private String movieName;
    private Genre genre;
    private int runningTime;

    public Movie(String movieName, Genre genre, int runningTime) {

        this.movieName = movieName;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    public int getMovieID() {
        return movieID;
    }

    public void setMovieID(int movieID) {
        this.movieID = movieID;
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
