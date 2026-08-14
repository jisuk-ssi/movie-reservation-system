package com.holic.moviereservationsystem.repository;

import com.holic.moviereservationsystem.model.Screening;

import java.util.ArrayList;
import java.util.List;

public class ScreeningRepository {

    private final List<Screening> screeningList = new ArrayList<>();
    private int sequence = 1;

    // 상영 정보 저장
    public Screening save(Screening screening) {
        screening.setScreeningId(sequence++);
        screeningList.add(screening);

        return screening;
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
