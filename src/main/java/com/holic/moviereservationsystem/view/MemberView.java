package com.holic.moviereservationsystem.view;

import com.holic.moviereservationsystem.model.Member;

import java.util.List;
import java.util.Scanner;

public class MemberView {

    private final Scanner scanner;

    public MemberView(Scanner scanner) {
        this.scanner = scanner;
    }

    // 회원 관리 메뉴 출력 및 선택값 입력
    public int selectMemberMenu() {
        System.out.println();
        System.out.println("===== 회원 관리 =====");
        System.out.println("1. 회원 등록");
        System.out.println("2. 회원 전체 조회");
        System.out.println("3. 회원 번호로 조회");
        System.out.println("4. 회원 수정");
        System.out.println("5. 회원 삭제");
        System.out.println("9. 이전 메뉴");

        return readInt("메뉴 선택: ");
    }

    // 일반 메시지 출력
    public void displayMessage(String message) {
        System.out.println(message);
    }

    // 오류 메시지 출력
    public void displayError(String message) {
        System.out.println("[오류] " + message);
    }

    // 성공 메시지 출력
    public void displaySuccess(String message) {
        System.out.println("[완료] " + message);
    }

    // 회원 한 명 상세 조회
    public void displayMember(Member member) {

        System.out.println();
        System.out.println("---------- 회원 상세 정보 ----------");
        System.out.println("회원 번호 : " + member.getMemberId());
        System.out.println("회원 이름 : " + member.getMemberName());
        System.out.println("전화번호  : " + member.getPhoneNumber());
    }

    // 회원 전체 조회
    public void displayMemberList(List<Member> members) {

        if (members.isEmpty()) {
            System.out.println("조회된 회원이 없습니다.");
            return;
        }

        System.out.println();
        System.out.println("---------- 회원 목록 ----------");

        for (Member member : members) {
            System.out.println(
                    member.getMemberId() + " | "
                            + member.getMemberName() + " | "
                            + member.getPhoneNumber()
            );
        }

        System.out.println("-----------------------------");
        System.out.println("총 " + members.size() + "명");
    }

    // 숫자 입력
    public int readInt(String prompt) {

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                displayError("숫자를 입력해주세요.");
            }
        }
    }

    // 문자열 입력
    public String readLine(String prompt) {

        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            displayError("한 글자 이상 입력해주세요.");
        }
    }

    // Scanner 종료
    public void close() {
        scanner.close();
    }
}
