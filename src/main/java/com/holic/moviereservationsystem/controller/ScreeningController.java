package com.holic.moviereservationsystem.controller;

import com.holic.moviereservationsystem.model.Movie;
import com.holic.moviereservationsystem.model.Screening;
import com.holic.moviereservationsystem.repository.MovieRepository;
import com.holic.moviereservationsystem.repository.ReservationRepository;
import com.holic.moviereservationsystem.repository.ScreeningRepository;
import com.holic.moviereservationsystem.view.ScreeningView;

import java.time.LocalDateTime;

public class ScreeningController {

    private final ScreeningRepository screeningRepository;
    private final MovieRepository movieRepository;
    private final ReservationRepository reservationRepository;
    private final ScreeningView screeningView;

    public ScreeningController(ScreeningRepository screeningRepository,
                               MovieRepository movieRepository,
                               ReservationRepository reservationRepository,
                               ScreeningView screeningView) {

        this.screeningRepository = screeningRepository;
        this.movieRepository = movieRepository;
        this.reservationRepository = reservationRepository;
        this.screeningView = screeningView;
    }

    //sub-menu
    public void run() {

        while (true) {

            int choice = screeningView.selectScreeningMenu();

            switch (choice) {

                case 1:
                    registerScreening();
                    break;

                case 2:
                    findAllScreenings();
                    break;

                case 3:
                    findScreeningById();
                    break;

                case 4:
                    updateScreening();
                    break;

                case 5:
                    deleteScreening();
                    break;

                case 9:
                    return;

                default:
                    screeningView.displayError(
                            "올바른 메뉴 번호를 입력해주세요."
                    );
            }
        }
    }

    // 상영정보 등록
    private void registerScreening() {

        int movieId =
                screeningView.readInt("영화 번호: ");

        Movie movie =
                movieRepository.findById(movieId);

        if (movie == null) {
            screeningView.displayError(
                    "해당 영화가 존재하지 않습니다."
            );
            return;
        }

        LocalDateTime startTime =
                screeningView.readLocalDateTime(
                        "상영 시작 시간"
                );

        String theater =
                screeningView.readLine("상영관: ");

        int remainingSeats;

        while (true) {

            remainingSeats =
                    screeningView.readInt("잔여 좌석 수: ");

            if (remainingSeats >= 0) {
                break;
            }

            screeningView.displayError(
                    "잔여 좌석은 0 이상이어야 합니다."
            );
        }

        Screening screening =
                new Screening(
                        movie,
                        startTime,
                        theater,
                        remainingSeats
                );

        screeningRepository.save(screening);

        screeningView.displaySuccess(
                "상영정보가 등록되었습니다."
        );
    }

    // 상영정보 전체 조회
    private void findAllScreenings() {

        screeningView.displayScreeningList(
                screeningRepository.findAll()
        );
    }

    // 상영정보 번호로 조회
    private void findScreeningById() {

        int screeningId =
                screeningView.readInt("상영 번호: ");

        Screening screening =
                screeningRepository.findById(screeningId);

        if (screening == null) {
            screeningView.displayError(
                    "해당 상영정보가 존재하지 않습니다."
            );
            return;
        }

        screeningView.displayScreening(screening);
    }

    // 상영정보 수정
    private void updateScreening() {

        int screeningId =
                screeningView.readInt(
                        "수정할 상영 번호: "
                );

        Screening screening =
                screeningRepository.findById(screeningId);

        if (screening == null) {
            screeningView.displayError(
                    "해당 상영정보가 존재하지 않습니다."
            );
            return;
        }

        int movieId =
                screeningView.readInt(
                        "새 영화 번호: "
                );

        Movie movie =
                movieRepository.findById(movieId);

        if (movie == null) {
            screeningView.displayError(
                    "해당 영화가 존재하지 않습니다."
            );
            return;
        }

        LocalDateTime startTime =
                screeningView.readLocalDateTime(
                        "새 상영 시작 시간"
                );

        String theater =
                screeningView.readLine(
                        "새 상영관: "
                );

        int remainingSeats;

        while (true) {

            remainingSeats =
                    screeningView.readInt(
                            "새 잔여 좌석 수: "
                    );

            if (remainingSeats >= 0) {
                break;
            }

            screeningView.displayError(
                    "잔여 좌석은 0 이상이어야 합니다."
            );
        }

        screening.setMovie(movie);
        screening.setStartTime(startTime);
        screening.setTheater(theater);
        screening.setRemainingSeats(remainingSeats);

        screeningView.displaySuccess(
                "상영정보가 수정되었습니다."
        );
    }

    // 상영정보 삭제
    private void deleteScreening() {

        int screeningId =
                screeningView.readInt(
                        "삭제할 상영 번호: "
                );

        if (screeningRepository.findById(screeningId) == null) {
            screeningView.displayError(
                    "해당 상영정보가 존재하지 않습니다."
            );
            return;
        }

        // 예매가 참조하는 상영정보를 삭제하면 고아 예매가 생기므로 삭제를 차단한다.
        if (reservationRepository.existsByScreeningId(screeningId)) {
            screeningView.displayError(
                    "예매 내역이 있는 상영정보는 삭제할 수 없습니다."
            );
            return;
        }

        boolean deleted =
                screeningRepository.deleteById(screeningId);

        if (!deleted) {
            screeningView.displayError(
                    "해당 상영정보가 존재하지 않습니다."
            );
            return;
        }

        screeningView.displaySuccess(
                "상영정보가 삭제되었습니다."
        );
    }
}
