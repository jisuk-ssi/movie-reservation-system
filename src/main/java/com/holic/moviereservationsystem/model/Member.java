package com.holic.moviereservationsystem.model;

public class Member {

    private int memberID;
    private String memberName;
    private String phoneNumber;

    public Member(int memberID, String memberName, String phoneNumber) {

        this.memberID = memberID;
        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
    }
}
