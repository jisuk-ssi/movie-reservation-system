package com.holic.moviereservationsystem;

import com.holic.moviereservationsystem.model.*;
import com.holic.moviereservationsystem.view.MemberView;
import com.holic.moviereservationsystem.view.MovieView;
import com.holic.moviereservationsystem.view.ReservationView;
import com.holic.moviereservationsystem.view.ScreeningView;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        MovieView movieView = new MovieView(scanner);
        MemberView memberView = new MemberView(scanner);
        ScreeningView screeningView = new ScreeningView(scanner);
        ReservationView reservationView = new ReservationView(scanner);

        // 프로그램 실행...

        scanner.close();

    }
}
