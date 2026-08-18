package com.holic.moviereservationsystem.view;

import com.holic.moviereservationsystem.model.Genre;
import com.holic.moviereservationsystem.model.Movie;

import java.util.List;
import java.util.Scanner;

public class MovieView {

    private final Scanner scanner;

    public MovieView(Scanner scanner) {
        this.scanner = scanner;
    }

    // 영화 관리 메뉴 출력 및 선택값 입력
    public int selectMovieMenu() {
        System.out.println();
        System.out.println("===== 영화 관리 =====");
        System.out.println("1. 영화 등록");
        System.out.println("2. 영화 전체 조회");
        System.out.println("3. 영화 번호로 조회");
        System.out.println("4. 영화 수정");
        System.out.println("5. 영화 삭제");
        System.out.println("9. 이전 메뉴");

        return readInt("메뉴 선택: ");
    }

    // 일반 메시지 출력
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // 오류 메시지 출력
    public void displayError(String message) {
        System.out.println("[오류] " + message);
    }

    // 성공 메시지 출력
    public void displaySuccess(String message) {
        System.out.println("[완료] " + message);
    }

    // 영화 한 편 상세 조회
    public void displayMovie(Movie movie) {

        System.out.println();
        System.out.println("---------- 영화 상세 정보 ----------");
        System.out.println("영화 번호 : " + movie.getMovieId());
        System.out.println("영화 제목 : " + movie.getMovieName());
        System.out.println("장르      : " + movie.getGenre().getKorean());
        System.out.println("상영 시간 : " + movie.getRunningTime() + "분");
    }

    // 영화 전체 조회
    public void displayMovieList(List<Movie> movies) {

        if (movies.isEmpty()) {
            System.out.println("조회된 영화가 없습니다.");
            return;
        }

        System.out.println();
        System.out.println("---------- 영화 목록 ----------");

        for (Movie movie : movies) {
            System.out.println(
                    movie.getMovieId() + " | "
                            + movie.getMovieName() + " | "
                            + movie.getGenre().getKorean() + " | "
                            + movie.getRunningTime() + "분"
            );
        }

        System.out.println("-------------------------------");
        System.out.println("총 " + movies.size() + "편");
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

    // 장르 입력
    public Genre readGenre(String prompt) {

        System.out.println();
        System.out.println(prompt);

        Genre[] genres = Genre.values();

        for (int i = 0; i < genres.length; i++) {
            System.out.println(
                    (i + 1) + ". " + genres[i].getKorean()
            );
        }

        while (true) {
            int choice = readInt("선택: ");

            if (choice >= 1 && choice <= genres.length) {
                return genres[choice - 1];
            }

            displayError("올바른 장르 번호를 선택해주세요.");
        }
    }

    // Scanner 종료
    public void close() {
        scanner.close();
    }
}
