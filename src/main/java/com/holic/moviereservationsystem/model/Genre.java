package com.holic.moviereservationsystem.model;

public enum Genre {

    ACTION("액션"),
    COMEDY("코미디"),
    ROMANCE("로맨스"),
    THRILLER("스릴러"),
    HORROR("공포"),
    SF("공상과학"),
    FANTASY("판타지"),
    ANIMATION("애니메이션");

    private final String korean;

    Genre(String korean) {
        this.korean = korean;
    }

    public String getKorean() {
        return korean;
    }
}
