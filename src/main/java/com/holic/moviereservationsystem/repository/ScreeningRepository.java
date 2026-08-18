package com.holic.moviereservationsystem.repository;

import com.holic.moviereservationsystem.model.Screening;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScreeningRepository {

    private final List<Screening> screeningList = new ArrayList<>();
    private int sequence = 1;

    public ScreeningRepository(MovieRepository movieRepository) {
        initializeScreenings(movieRepository);
    }

    private void initializeScreenings(MovieRepository movieRepository) {
        save(new Screening(movieRepository.findById(1), LocalDateTime.of(2026, 8, 20, 10, 30), "1관", 99));
        save(new Screening(movieRepository.findById(2), LocalDateTime.of(2026, 8, 20, 13, 0), "2관", 80));
        save(new Screening(movieRepository.findById(3), LocalDateTime.of(2026, 8, 20, 15, 30), "3관", 59));
        save(new Screening(movieRepository.findById(4), LocalDateTime.of(2026, 8, 21, 18, 0), "1관", 100));
        save(new Screening(movieRepository.findById(5), LocalDateTime.of(2026, 8, 21, 20, 0), "IMAX관", 119));
        save(new Screening(movieRepository.findById(6), LocalDateTime.of(2026, 8, 22, 14, 0), "2관", 80));
    }

    // 상영 정보 저장
    public void save(Screening screening) {
        screening.setScreeningId(sequence++);
        screeningList.add(screening);
    }

    // ID로 상영 정보 조회
    public Screening findById(int id) {
        for (Screening screening : screeningList) {
            if (screening.getScreeningId() == id) {
                return screening;
            }
        }

        return null;
    }

    // 모든 상영 정보 조회
    public List<Screening> findAll() {
        return screeningList;
    }

    // ID로 상영 정보 삭제
    public boolean deleteById(int id) {
        return screeningList.removeIf(screening -> screening.getScreeningId() == id);
    }
}
