package com.holic.moviereservationsystem.repository;

import com.holic.moviereservationsystem.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private List<Movie> movieList = new ArrayList<>();
    private int sequence = 1;

    // 영화 저장
    public Movie save(Movie movie) {
        movie.setMovieID(sequence++);
        movieList.add(movie);

        return movie;
    }

    // ID로 영화 조회
    public Movie findById(int id) {
        for (Movie movie : movieList) {
            if (movie.getMovieID() == id) {
                return movie;
            }
        }

        return null;
    }

    // 모든 영화 조회
    public List<Movie> findAll() {
        return movieList;
    }

    // ID로 영화 삭제
    public boolean deleteById(int id) {
        return movieList.removeIf(movie -> movie.getMovieID() == id);
    }
}
