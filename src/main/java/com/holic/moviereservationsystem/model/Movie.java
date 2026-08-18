package com.holic.moviereservationsystem.model;

public class Movie {

    private int movieId;
    private String movieName;
    private Genre genre;
    private int runningTime;

    public Movie(String movieName, Genre genre, int runningTime) {

        this.movieName = movieName;
        this.genre = genre;
        this.runningTime = runningTime;
    }

    //setter 및 getter
    public void setMovieId(int movieId) {
        this.movieId = movieId;
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
        return movieId;
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
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", genre=" + genre +
                ", runningTime=" + runningTime +
                ']';
    }
}
