package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    private int wiseSayingLastId = 0;   // 가장 마지막으로 추가된 명언 글 번호
    private List<WiseSaying> wiseSayings;   // 명언 리스트
    public App(Scanner sc) {
        this.sc = sc;
        this.wiseSayings = new ArrayList<>();
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
                    String content = sc.nextLine();
                    System.out.println("작가 : ");
                    String author = sc.nextLine();
                    // 리스트에 WiseSaying 인스턴스 삽입
                    wiseSayings.add(new WiseSaying(id, content, author));
                    System.out.printf("%d번 명언이 등록되었습니다.\n", id);
                    break;
                case "목록":
                    System.out.println("번호 / 작가 / 명언");
                    System.out.println("----------------------");
                    // 명언 최신순(역순) 출력
                    for (int i = wiseSayings.size() - 1; i >= 0; i--) {
                        WiseSaying ws = wiseSayings.get(i);
                        System.out.printf("%d / %s / %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
                    }
                    break;
                case "종료":
                    break outer;    // outer 라벨이 붙은 곳에서 break
            }
        }
    }
}
