package com.holic.moviereservationsystem.repository;

import com.holic.moviereservationsystem.model.Reservation;
import com.holic.moviereservationsystem.model.Screening;

import java.util.ArrayList;
import java.util.List;

public class ReservationRepository {
    private final List<Reservation> reservationList = new ArrayList<>();
    private int sequence = 1;

    public ReservationRepository(MemberRepository memberRepository,
                                 ScreeningRepository screeningRepository) {
        initializeReservations(memberRepository, screeningRepository);
    }

    private void initializeReservations(MemberRepository memberRepository,
                                        ScreeningRepository screeningRepository) {
        saveInitialReservation(memberRepository, screeningRepository, 1, 1);
        saveInitialReservation(memberRepository, screeningRepository, 2, 3);
        saveInitialReservation(memberRepository, screeningRepository, 3, 5);
    }

    private void saveInitialReservation(MemberRepository memberRepository,
                                        ScreeningRepository screeningRepository,
                                        int memberId,
                                        int screeningId) {
        Screening screening = screeningRepository.findById(screeningId);

        save(new Reservation(memberRepository.findById(memberId), screening));
    }

    // 예매 저장
    public void save(Reservation reservation) {
        reservation.setReservationId(sequence++);
        reservationList.add(reservation);
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
