package com.holic.moviereservationsystem.view;

import com.holic.moviereservationsystem.model.Reservation;

import java.util.List;
import java.util.Scanner;

public class ReservationView {

    private final Scanner scanner;

    public ReservationView(Scanner scanner) {
        this.scanner = scanner;
    }

    // 예매 관리 메뉴 출력 및 선택값 입력
    public int selectReservationMenu() {
        System.out.println();
        System.out.println("===== 예매 관리 =====");
        System.out.println("1. 예매 등록");
        System.out.println("2. 예매 전체 조회");
        System.out.println("3. 예매 번호로 조회");
        System.out.println("4. 예매 수정");
        System.out.println("5. 예매 삭제");
        System.out.println("9. 이전 메뉴");

        return readInt("메뉴 선택: ");
    }

    // 오류 메시지 출력
    public void displayError(String message) {
        System.out.println("[오류] " + message);
    }

    // 성공 메시지 출력
    public void displaySuccess(String message) {
        System.out.println("[완료] " + message);
    }

    // 예매 한 건 상세 조회
    public void displayReservation(Reservation reservation) {

        System.out.println();
        System.out.println("---------- 예매 상세 정보 ----------");
        System.out.println("예매 번호 : " + reservation.getReservationId());
        System.out.println("회원 번호 : " + reservation.getMember().getMemberId());
        System.out.println("회원 이름 : " + reservation.getMember().getMemberName());
        System.out.println("상영 번호 : " + reservation.getScreening().getScreeningId());
        System.out.println("영화 번호 : " + reservation.getScreening().getMovie().getMovieId());
        System.out.println("영화 제목 : " + reservation.getScreening().getMovie().getMovieName());
        System.out.println("상영 시간 : " + reservation.getScreening().getStartTime());
        System.out.println("상영관    : " + reservation.getScreening().getTheater());
    }

    // 예매 전체 조회
    public void displayReservationList(List<Reservation> reservations) {

        if (reservations.isEmpty()) {
            System.out.println("조회된 예매가 없습니다.");
            return;
        }

        System.out.println();
        System.out.println("---------- 예매 목록 ----------");

        for (Reservation reservation : reservations) {
            System.out.println(
                    reservation.getReservationId() + " | "
                            + reservation.getMember().getMemberName() + " | "
                            + reservation.getScreening().getMovie().getMovieName() + " | "
                            + reservation.getScreening().getStartTime() + " | "
                            + reservation.getScreening().getTheater()
            );
        }

        System.out.println("-----------------------------");
        System.out.println("총 " + reservations.size() + "건");
    }

    // 숫자 입력
    public int readInt(String prompt) {

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                displayError("숫자를 입력해주세요.");
            }
        }
    }
}
