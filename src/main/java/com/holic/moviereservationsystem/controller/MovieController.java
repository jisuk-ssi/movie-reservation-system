package com.holic.moviereservationsystem.controller;

import com.holic.moviereservationsystem.model.Genre;
import com.holic.moviereservationsystem.model.Movie;
import com.holic.moviereservationsystem.repository.MovieRepository;
import com.holic.moviereservationsystem.view.MovieView;

public class MovieController {

    private final MovieRepository movieRepository;
    private final MovieView movieView;

    public MovieController(MovieRepository movieRepository,
                           MovieView movieView) {
        this.movieRepository = movieRepository;
        this.movieView = movieView;
    }

    public void run() {

        while (true) {

            int choice = movieView.selectMovieMenu();

            switch (choice) {

                case 1:
                    registerMovie();
                    break;

                case 2:
                    findAllMovies();
                    break;

                case 3:
                    findMovieById();
                    break;

                case 4:
                    updateMovie();
                    break;

                case 5:
                    deleteMovie();
                    break;

                case 9:
                    return;

                default:
                    movieView.displayError("올바른 메뉴 번호를 입력해주세요.");
            }
        }
    }

    // 영화 등록
    private void registerMovie() {

        String movieName =
                movieView.readLine("영화 제목: ");

        Genre genre =
                movieView.readGenre("장르를 선택해주세요.");

        int runningTime =
                movieView.readInt("상영 시간(분): ");

        Movie movie =
                new Movie(movieName, genre, runningTime);

        movieRepository.save(movie);

        movieView.displaySuccess("영화가 등록되었습니다.");
    }

    // 영화 전체 조회
    private void findAllMovies() {

        movieView.displayMovieList(
                movieRepository.findAll()
        );
    }

    // 영화 번호로 조회
    private void findMovieById() {

        int movieId =
                movieView.readInt("영화 번호: ");

        Movie movie =
                movieRepository.findById(movieId);

        if (movie == null) {
            movieView.displayError("해당 영화가 존재하지 않습니다.");
            return;
        }

        movieView.displayMovie(movie);
    }

    // 영화 수정
    private void updateMovie() {

        int movieId =
                movieView.readInt("수정할 영화 번호: ");

        Movie movie =
                movieRepository.findById(movieId);

        if (movie == null) {
            movieView.displayError("해당 영화가 존재하지 않습니다.");
            return;
        }

        String movieName =
                movieView.readLine("새 영화 제목: ");

        Genre genre =
                movieView.readGenre("새 장르를 선택해주세요.");

        int runningTime =
                movieView.readInt("새 상영 시간(분): ");

        movie.setMovieName(movieName);
        movie.setGenre(genre);
        movie.setRunningTime(runningTime);

        movieView.displaySuccess("영화 정보가 수정되었습니다.");
    }

    // 영화 삭제
    private void deleteMovie() {

        int movieId =
                movieView.readInt("삭제할 영화 번호: ");

        boolean deleted =
                movieRepository.deleteById(movieId);

        if (!deleted) {
            movieView.displayError("해당 영화가 존재하지 않습니다.");
            return;
        }

        movieView.displaySuccess("영화가 삭제되었습니다.");
    }
}
