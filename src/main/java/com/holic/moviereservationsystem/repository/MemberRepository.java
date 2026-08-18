package com.holic.moviereservationsystem.repository;

import com.holic.moviereservationsystem.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

    private final List<Member> memberList = new ArrayList<>();
    private int sequence = 1;

    public MemberRepository() {
        initializeMembers();
    }

    //초기값 입력
    private void initializeMembers() {
        save(new Member("김민준", "010-1234-5678"));
        save(new Member("이서연", "010-2345-6789"));
        save(new Member("박지훈", "010-3456-7890"));
        save(new Member("최유진", "010-4567-8901"));
        save(new Member("정현우", "010-5678-9012"));
    }

    // 회원 저장
    public void save(Member member) {
        member.setMemberId(sequence++);
        memberList.add(member);
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
