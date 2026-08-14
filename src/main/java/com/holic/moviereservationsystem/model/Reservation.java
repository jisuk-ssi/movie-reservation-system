package com.holic.moviereservationsystem.model;

public class Reservation {

    private int reservationID;
    private Member member;
    private Movie movie;

    public Reservation(Member member, Movie movie) {

        this.member = member;
        this.movie = movie;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {}

    public Member getMember() {
        return member;
    }

    public Movie getMovie() {
        return movie;
    }
}
