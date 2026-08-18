package com.holic.moviereservationsystem.repository;

import com.holic.moviereservationsystem.model.Genre;
import com.holic.moviereservationsystem.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieRepository {

    private final List<Movie> movieList = new ArrayList<>();
    private int sequence = 1;

    public MovieRepository() {
        initializeMovies();
    }

    private void initializeMovies() {
        save(new Movie("범죄도시", Genre.ACTION, 121));
        save(new Movie("극한직업", Genre.COMEDY, 111));
        save(new Movie("어바웃 타임", Genre.ROMANCE, 123));
        save(new Movie("기생충", Genre.THRILLER, 131));
        save(new Movie("인터스텔라", Genre.SF, 169));
        save(new Movie("센과 치히로의 행방불명", Genre.ANIMATION, 126));
    }

    // 영화 저장
    public void save(Movie movie) {
        movie.setMovieId(sequence++);
        movieList.add(movie);
    }

    // ID로 영화 조회
    public Movie findById(int id) {
        for (Movie movie : movieList) {
            if (movie.getMovieId() == id) {
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
        return movieList.removeIf(movie -> movie.getMovieId() == id);
    }
}
