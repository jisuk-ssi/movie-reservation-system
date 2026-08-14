package com.holic.moviereservationsystem.model;

public class Reservation {

    private int reservationID;
    private Member member;
    private Movie movie;
    private String seat;

    public Reservation(int reservationID, Member member, Movie movie, String seat) {

        this.reservationID = reservationID;
        this.member = member;
        this.movie = movie;
        this.seat = seat;
    }
}
