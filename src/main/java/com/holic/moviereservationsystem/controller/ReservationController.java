package com.holic.moviereservationsystem.controller;

import com.holic.moviereservationsystem.model.Member;
import com.holic.moviereservationsystem.model.Reservation;
import com.holic.moviereservationsystem.model.Screening;
import com.holic.moviereservationsystem.repository.MemberRepository;
import com.holic.moviereservationsystem.repository.ReservationRepository;
import com.holic.moviereservationsystem.repository.ScreeningRepository;
import com.holic.moviereservationsystem.view.ReservationView;

public class ReservationController {

    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;
    private final ScreeningRepository screeningRepository;
    private final ReservationView reservationView;

    public ReservationController(ReservationRepository reservationRepository,
                                 MemberRepository memberRepository,
                                 ScreeningRepository screeningRepository,
                                 ReservationView reservationView) {

        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.screeningRepository = screeningRepository;
        this.reservationView = reservationView;
    }

    public void run() {

        while (true) {

            int choice = reservationView.selectReservationMenu();

            switch (choice) {

                case 1:
                    registerReservation();
                    break;

                case 2:
                    findAllReservations();
                    break;

                case 3:
                    findReservationById();
                    break;

                case 4:
                    updateReservation();
                    break;

                case 5:
                    deleteReservation();
                    break;

                case 9:
                    return;

                default:
                    reservationView.displayError(
                            "올바른 메뉴 번호를 입력해주세요."
                    );
            }
        }
    }

    // 예매 등록
    private void registerReservation() {

        int memberId =
                reservationView.readInt("회원 번호: ");

        Member member =
                memberRepository.findById(memberId);

        if (member == null) {
            reservationView.displayError(
                    "해당 회원이 존재하지 않습니다."
            );
            return;
        }

        int screeningId =
                reservationView.readInt("상영 번호: ");

        Screening screening =
                screeningRepository.findById(screeningId);

        if (screening == null) {
            reservationView.displayError(
                    "해당 상영정보가 존재하지 않습니다."
            );
            return;
        }

        // 잔여 좌석 확인
        if (screening.getRemainingSeats() <= 0) {
            reservationView.displayError(
                    "잔여 좌석이 없어 예매할 수 없습니다."
            );
            return;
        }

        Reservation reservation =
                new Reservation(member, screening);

        reservationRepository.save(reservation);

        // 예매 성공 시 잔여 좌석 1 감소
        screening.setRemainingSeats(
                screening.getRemainingSeats() - 1
        );

        reservationView.displaySuccess(
                "예매가 등록되었습니다."
        );
    }

    // 예매 전체 조회
    private void findAllReservations() {

        reservationView.displayReservationList(
                reservationRepository.findAll()
        );
    }

    // 예매 번호로 조회
    private void findReservationById() {

        int reservationId =
                reservationView.readInt("예매 번호: ");

        Reservation reservation =
                reservationRepository.findById(reservationId);

        if (reservation == null) {
            reservationView.displayError(
                    "해당 예매가 존재하지 않습니다."
            );
            return;
        }

        reservationView.displayReservation(reservation);
    }

    // 예매 수정
    private void updateReservation() {

        int reservationId =
                reservationView.readInt(
                        "수정할 예매 번호: "
                );

        Reservation reservation =
                reservationRepository.findById(reservationId);

        if (reservation == null) {
            reservationView.displayError(
                    "해당 예매가 존재하지 않습니다."
            );
            return;
        }

        int memberId =
                reservationView.readInt(
                        "새 회원 번호: "
                );

        Member member =
                memberRepository.findById(memberId);

        if (member == null) {
            reservationView.displayError(
                    "해당 회원이 존재하지 않습니다."
            );
            return;
        }

        int screeningId =
                reservationView.readInt(
                        "새 상영 번호: "
                );

        Screening newScreening =
                screeningRepository.findById(screeningId);

        if (newScreening == null) {
            reservationView.displayError(
                    "해당 상영정보가 존재하지 않습니다."
            );
            return;
        }

        Screening oldScreening =
                reservation.getScreening();

        // 다른 상영으로 변경하는 경우
        if (oldScreening.getScreeningId()
                != newScreening.getScreeningId()) {

            if (newScreening.getRemainingSeats() <= 0) {
                reservationView.displayError(
                        "변경하려는 상영의 잔여 좌석이 없습니다."
                );
                return;
            }

            // 기존 상영 좌석 복구
            oldScreening.setRemainingSeats(
                    oldScreening.getRemainingSeats() + 1
            );

            // 새로운 상영 좌석 감소
            newScreening.setRemainingSeats(
                    newScreening.getRemainingSeats() - 1
            );
        }

        reservation.setMember(member);
        reservation.setScreening(newScreening);

        reservationView.displaySuccess(
                "예매 정보가 수정되었습니다."
        );
    }

    // 예매 삭제
    private void deleteReservation() {

        int reservationId =
                reservationView.readInt(
                        "삭제할 예매 번호: "
                );

        Reservation reservation =
                reservationRepository.findById(reservationId);

        if (reservation == null) {
            reservationView.displayError(
                    "해당 예매가 존재하지 않습니다."
            );
            return;
        }

        // 예매 취소 시 기존 상영의 좌석 1개 복구
        Screening screening =
                reservation.getScreening();

        boolean deleted =
                reservationRepository.deleteById(reservationId);

        if (deleted) {

            screening.setRemainingSeats(
                    screening.getRemainingSeats() + 1
            );

            reservationView.displaySuccess(
                    "예매가 삭제되었습니다."
            );
        }
    }
}
