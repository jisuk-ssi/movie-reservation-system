package com.holic.moviereservationsystem.model;

public class Member {

    private int memberId;
    private String memberName;
    private String phoneNumber;

    public Member(String memberName, String phoneNumber) {

        this.memberName = memberName;
        this.phoneNumber = phoneNumber;
    }

    //setter 및 getter
    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Member[" +
                "memberID=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ']';
    }
}
