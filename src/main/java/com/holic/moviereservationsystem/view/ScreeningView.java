package com.holic.moviereservationsystem.view;

import com.holic.moviereservationsystem.model.Screening;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ScreeningView {

    private final Scanner scanner;

    public ScreeningView(Scanner scanner) {
        this.scanner = scanner;
    }

    // 상영정보 관리 메뉴 출력 및 선택값 입력
    public int selectScreeningMenu() {
        System.out.println();
        System.out.println("===== 상영정보 관리 =====");
        System.out.println("1. 상영정보 등록");
        System.out.println("2. 상영정보 전체 조회");
        System.out.println("3. 상영정보 번호로 조회");
        System.out.println("4. 상영정보 수정");
        System.out.println("5. 상영정보 삭제");
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

    // 상영정보 한 건 상세 조회
    public void displayScreening(Screening screening) {

        System.out.println();
        System.out.println("---------- 상영정보 상세 ----------");
        System.out.println("상영 번호 : " + screening.getScreeningId());
        System.out.println("영화 제목 : " + screening.getMovie().getMovieName());
        System.out.println("시작 시간 : " + screening.getStartTime());
        System.out.println("상영관    : " + screening.getTheater());
        System.out.println("잔여 좌석 : " + screening.getRemainingSeats());
    }

    // 상영정보 전체 조회
    public void displayScreeningList(List<Screening> screenings) {

        if (screenings.isEmpty()) {
            System.out.println("조회된 상영정보가 없습니다.");
            return;
        }

        System.out.println();
        System.out.println("---------- 상영정보 목록 ----------");

        for (Screening screening : screenings) {
            System.out.println(
                    screening.getScreeningId() + " | "
                            + screening.getMovie().getMovieName() + " | "
                            + screening.getStartTime() + " | "
                            + screening.getTheater() + " | "
                            + "잔여 좌석: " + screening.getRemainingSeats()
            );
        }

        System.out.println("---------------------------------");
        System.out.println("총 " + screenings.size() + "건");
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

    // 문자열 입력
    public String readLine(String prompt) {

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            displayError("한 글자 이상 입력해주세요.");
        }
    }

    // 날짜와 시간 입력
    public LocalDateTime readLocalDateTime(String prompt) {

        while (true) {
            System.out.print(prompt + " (예: 2026-08-18T14:30): ");
            String input = scanner.nextLine().trim();

            try {
                return LocalDateTime.parse(input);
            } catch (DateTimeParseException e) {
                displayError("날짜와 시간을 올바른 형식으로 입력해주세요.");
            }
        }
    }
}
