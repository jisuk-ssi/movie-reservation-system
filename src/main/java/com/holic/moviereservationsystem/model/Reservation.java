package com.holic.moviereservationsystem.model;

public class Reservation {

    private int reservationId;
    private Member member;
    private Screening screening;

    public Reservation(Member member, Screening screening) {

        this.member = member;
        this.screening = screening;
    }

    //setter 및 getter
    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public int getReservationId() {
        return reservationId;
    }

    public Member getMember() {
        return member;
    }

    public Screening getScreening() {
        return screening;
    }

    @Override
    public String toString() {
        return "Reservation [reservationId=" + reservationId +
                ", member=" + member +
                ", screening=" + screening +
                "]";
    }
}
