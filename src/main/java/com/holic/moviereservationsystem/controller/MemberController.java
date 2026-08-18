package com.holic.moviereservationsystem.controller;

import com.holic.moviereservationsystem.model.Member;
import com.holic.moviereservationsystem.repository.MemberRepository;
import com.holic.moviereservationsystem.repository.ReservationRepository;
import com.holic.moviereservationsystem.view.MemberView;

public class MemberController {

    private final MemberRepository memberRepository;
    private final ReservationRepository reservationRepository;
    private final MemberView memberView;

    public MemberController(MemberRepository memberRepository,
                            ReservationRepository reservationRepository,
                            MemberView memberView) {

        this.memberRepository = memberRepository;
        this.reservationRepository = reservationRepository;
        this.memberView = memberView;
    }

    //sub-menu
    public void run() {

        while (true) {

            int choice = memberView.selectMemberMenu();

            switch (choice) {

                case 1:
                    registerMember();
                    break;

                case 2:
                    findAllMembers();
                    break;

                case 3:
                    findMemberById();
                    break;

                case 4:
                    updateMember();
                    break;

                case 5:
                    deleteMember();
                    break;

                case 9:
                    return;

                default:
                    memberView.displayError("올바른 메뉴 번호를 입력해주세요.");
            }
        }
    }

    // 회원 등록
    public void registerMember() {

        String memberName =
                memberView.readLine("회원 이름: ");

        String phoneNumber =
                memberView.readLine("전화번호: ");

        Member member =
                new Member(memberName, phoneNumber);

        memberRepository.save(member);

        memberView.displaySuccess("회원이 등록되었습니다.");
    }

    // 회원 전체 조회
    public void findAllMembers() {

        memberView.displayMemberList(
                memberRepository.findAll()
        );
    }

    // 회원 번호로 조회
    public void findMemberById() {

        int memberId =
                memberView.readInt("회원 번호: ");

        Member member =
                memberRepository.findById(memberId);

        if (member == null) {
            memberView.displayError("해당 회원이 존재하지 않습니다.");
            return;
        }

        memberView.displayMember(member);
    }

    // 회원 수정
    private void updateMember() {

        int memberId =
                memberView.readInt("수정할 회원 번호: ");

        Member member =
                memberRepository.findById(memberId);

        if (member == null) {
            memberView.displayError("해당 회원이 존재하지 않습니다.");
            return;
        }

        String memberName =
                memberView.readLine("새 회원 이름: ");

        String phoneNumber =
                memberView.readLine("새 전화번호: ");

        member.setMemberName(memberName);
        member.setPhoneNumber(phoneNumber);

        memberView.displaySuccess("회원 정보가 수정되었습니다.");
    }

    // 회원 삭제
    private void deleteMember() {

        int memberId =
                memberView.readInt("삭제할 회원 번호: ");

        if (memberRepository.findById(memberId) == null) {
            memberView.displayError("해당 회원이 존재하지 않습니다.");
            return;
        }

        // 예매가 참조하는 회원을 삭제하면 고아 예매가 생기므로 삭제를 차단한다.
        if (reservationRepository.existsByMemberId(memberId)) {
            memberView.displayError("예매 내역이 있는 회원은 삭제할 수 없습니다.");
            return;
        }

        boolean deleted =
                memberRepository.deleteById(memberId);

        if (!deleted) {
            memberView.displayError("해당 회원이 존재하지 않습니다.");
            return;
        }

        memberView.displaySuccess("회원이 삭제되었습니다.");
    }
}
