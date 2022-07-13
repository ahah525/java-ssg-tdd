package com.ll.exam;

import com.ll.exam.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private WiseSayingController wiseSayingController;

    public App(Scanner sc) {
        this.sc = sc;
    }

    // 실행 메서드
    public void run() {
        System.out.println("== 명언 SSG ==");
        wiseSayingController = new WiseSayingController(sc);  // 컨트롤러 생성

        outer:
        while (true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine().trim();  // 한 줄 입력받고 앞뒤 공백 제거
            Rq rq = new Rq(cmd);

            switch (rq.getPath()) {
                case "등록":
                    wiseSayingController.write(rq);
                    break;
                case "목록":
                    wiseSayingController.list(rq);
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
                case "수정":
                    wiseSayingController.modify(rq);
                    break;
                case "종료":
                    break outer;    // outer 라벨이 붙은 곳에서 break
            }
        }
    }
}
