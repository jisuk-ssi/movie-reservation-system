package com.holic.moviereservationsystem.model;

public class Reservation {

    private int reservationID;
    private Member member;
    private Movie movie;

    public Reservation(int reservationID, Member member, Movie movie) {

        this.reservationID = reservationID;
        this.member = member;
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
}
