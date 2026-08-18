package com.holic.moviereservationsystem.repository;

import com.holic.moviereservationsystem.model.Reservation;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private final List<Reservation> reservationList = new ArrayList<>();
    private int sequence = 1;

    // 예매 저장
    public Reservation save(Reservation reservation) {
        reservation.setReservationId(sequence++);
        reservationList.add(reservation);

        return reservation;
    }

    // ID로 예매 조회
    public Reservation findById(int id) {
        for (Reservation reservation : reservationList) {
            if (reservation.getReservationId() == id) {
                return reservation;
            }
        }

        return null;
    }

    // 모든 예매 조회
    public List<Reservation> findAll() {
        return reservationList;
    }

    // ID로 예매 삭제
    public boolean deleteById(int id) {
        return reservationList.removeIf(
                reservation -> reservation.getReservationId() == id
        );
    }
}
