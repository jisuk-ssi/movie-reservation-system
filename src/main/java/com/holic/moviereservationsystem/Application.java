package com.holic.moviereservationsystem;

import com.holic.moviereservationsystem.controller.MemberController;
import com.holic.moviereservationsystem.controller.MovieController;
import com.holic.moviereservationsystem.controller.ReservationController;
import com.holic.moviereservationsystem.controller.ScreeningController;
import com.holic.moviereservationsystem.repository.MemberRepository;
import com.holic.moviereservationsystem.repository.MovieRepository;
import com.holic.moviereservationsystem.repository.ReservationRepository;
import com.holic.moviereservationsystem.repository.ScreeningRepository;
import com.holic.moviereservationsystem.view.MemberView;
import com.holic.moviereservationsystem.view.MovieView;
import com.holic.moviereservationsystem.view.ReservationView;
import com.holic.moviereservationsystem.view.ScreeningView;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        //공유될 scanner 인스턴스 생성
        Scanner scanner = new Scanner(System.in);

        //프로그램 전체에서 사용할 repository 생성
        MemberRepository memberRepository = new MemberRepository();
        MovieRepository movieRepository = new MovieRepository();
        ScreeningRepository screeningRepository = new ScreeningRepository(movieRepository);
        ReservationRepository reservationRepository = new ReservationRepository(memberRepository, screeningRepository);

        //프로그램 내에서 보여질 view menu 생성 (scanner 공유)
        MemberView memberView = new MemberView(scanner);
        MovieView movieView = new MovieView(scanner);
        ScreeningView screeningView = new ScreeningView(scanner);
        ReservationView reservationView = new ReservationView(scanner);

        //내부에서 작동하는 controller 생성
        MemberController memberController =
                new MemberController(memberRepository, reservationRepository, memberView);
        MovieController movieController =
                new MovieController(movieRepository, screeningRepository, movieView);
        ScreeningController screeningController =
                new ScreeningController(
                        screeningRepository,
                        movieRepository,
                        reservationRepository,
                        screeningView
                );
        ReservationController reservationController =
                new ReservationController(
                        reservationRepository,
                        memberRepository,
                        screeningRepository,
                        reservationView
                );

        System.out.println("영화 예매 시스템을 시작합니다.");

        //main menu
        while (true) {
            System.out.println();
            System.out.println("========== 영화 예매 시스템 ==========");
            System.out.println("1. 회원 관리");
            System.out.println("2. 영화 관리");
            System.out.println("3. 상영 관리");
            System.out.println("4. 예매 관리");
            System.out.println("9. 프로그램 종료");

            int choice = memberView.readInt("메뉴를 선택하세요: ");

            switch (choice) {
                case 1 -> memberController.run();
                case 2 -> movieController.run();
                case 3 -> screeningController.run();
                case 4 -> reservationController.run();
                case 9 -> {
                    System.out.println("프로그램을 종료합니다.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("메뉴에 있는 번호를 선택해주세요.");
            }
        }
    }
}
