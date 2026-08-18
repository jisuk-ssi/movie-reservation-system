package com.holic.moviereservationsystem.model;

public class Member {

    private int memberID;
    private String memberName;
    private String phoneNumber;

    public Member(String memberName, String phoneNumber) {

        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
    }

    //setter 및 getter
    public void setMemberID(int memberID) {}

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMemberID() {
        return memberID;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberID=" + memberID +
                ", memberName='" + memberName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
