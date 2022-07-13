package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private int wiseSayingLastId = 0;   // 가장 마지막으로 추가된 명언 글 번호
    public App(Scanner sc) {
        this.sc = sc;
    }

    // 실행 메서드
    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while (true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine().trim();  // 한 줄 입력받고 앞뒤 공백 제거

            switch (cmd) {
                case "등록":
                    int id = ++wiseSayingLastId;
                    System.out.println("명언 : ");
                    sc.nextLine();
                    System.out.println("작가 : ");
                    sc.nextLine();
                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;
                case "종료":
                    break outer;    // outer 라벨이 붙은 곳에서 break
            }
        }
    }
}
