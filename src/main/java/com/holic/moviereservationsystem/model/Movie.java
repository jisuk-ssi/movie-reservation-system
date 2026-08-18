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

    //setter 및 getter
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setRunningTime(int runningTime) {
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

    @Override
    public String toString() {
        return "Movie[" +
                "movieID=" + movieID +
                ", movieName='" + movieName + '\'' +
                ", genre=" + genre +
                ", runningTime=" + runningTime +
                ']';
    }
}
