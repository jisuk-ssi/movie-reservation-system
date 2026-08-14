package com.holic.moviereservationsystem.model;

public class Member {

    private int memberID;
    private String memberName;
    private String phoneNumber;

    public Member(String memberName, String phoneNumber) {

        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {}

    public String getMemberName() {
        return memberName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
