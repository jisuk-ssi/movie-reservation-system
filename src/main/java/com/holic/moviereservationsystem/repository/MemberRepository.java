package com.holic.moviereservationsystem.repository;

import com.holic.moviereservationsystem.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private List<Member> memberList = new ArrayList<>();
    private int sequence = 1;

    // 회원 저장
    public Member save(Member member) {
        member.setMemberId(sequence++);
        memberList.add(member);

        return member;
    }

    // ID로 회원 조회
    public Member findById(int id) {
        for (Member member : memberList) {
            if (member.getMemberId() == id) {
                return member;
            }
        }

        return null;
    }

    // 모든 회원 조회
    public List<Member> findAll() {
        return memberList;
    }

    // ID로 회원 삭제
    public boolean deleteById(int id) {
        return memberList.removeIf(member -> member.getMemberId() == id);
    }
}
