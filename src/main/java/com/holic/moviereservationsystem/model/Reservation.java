package com.holic.moviereservationsystem.model;

public class Reservation {

    private int reservationID;
    private Member member;
    private Movie movie;

    public Reservation(Member member, Movie movie) {

        this.member = member;
        this.movie = movie;
    }

    //setter 및 getter
    public void setReservationID(int reservationID) {}

    public void setMember(Member member) {
        this.member = member;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getReservationID() {
        return reservationID;
    }

    public Member getMember() {
        return member;
    }

    public Movie getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return "Reservation [reservationID=" + reservationID +
                ", member=" + member +
                ", movie='" + movie.getMovieName() + '\'' +
                "]";
    }
}
