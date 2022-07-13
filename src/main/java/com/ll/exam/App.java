package com.ll.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;
    private int wiseSayingLastId;   // 가장 마지막으로 추가된 명언 글 번호
    private List<WiseSaying> wiseSayings;   // 명언 리스트
    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingLastId = 0;
        wiseSayings = new ArrayList<>();
    }

    // 실행 메서드
    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while (true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine().trim();  // 한 줄 입력받고 앞뒤 공백 제거
            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
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
                case "삭제":
                    remove(rq);
                    break;
                case "종료":
                    break outer;    // outer 라벨이 붙은 곳에서 break
            }
        }
    }
    public void remove(Rq rq) {
        int id = rq.getIntParam("id", 0);
        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }
        WiseSaying foundWs = findById(id);  // id로 조회한 명언
        // 해당 id에 대한 명언이 존재하지 않는 경우 예외 처리
        if (foundWs == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        // 명언 삭제
        wiseSayings.remove(foundWs);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    // id로 명언 조회
    public WiseSaying findById(int id) {
        for (WiseSaying ws : wiseSayings) {
            if(ws.getId() == id)
                return ws;
        }
        return null;
    }
}
