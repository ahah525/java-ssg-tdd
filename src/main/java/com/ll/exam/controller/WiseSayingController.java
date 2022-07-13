package com.ll.exam.controller;

import com.ll.exam.Rq;
import com.ll.exam.WiseSaying;
import com.ll.exam.service.WiseSayingService;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private WiseSayingService wiseSayingService;    // 서비스

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }

    public void write(Rq rq) {
        System.out.println("명언 : ");
        String content = sc.nextLine();
        System.out.println("작가 : ");
        String author = sc.nextLine();
        // 명언 저장
        WiseSaying wiseSaying = wiseSayingService.write(content, author);
        System.out.printf("%d번 명언이 등록되었습니다.\n", wiseSaying.getId());
    }

    public void list(Rq rq) {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        // 모든 명언 조회
        List<WiseSaying> wiseSayings = wiseSayingService.findAll();
        // 명언 최신순(역순) 출력
        for (int i = wiseSayings.size() - 1; i >= 0; i--) {
            WiseSaying ws = wiseSayings.get(i);
            System.out.printf("%d / %s / %s\n", ws.getId(), ws.getAuthor(), ws.getContent());
        }
    }

    public void modify(Rq rq) {
        int id = rq.getIntParam("id", 0);
        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }
        WiseSaying foundWs = wiseSayingService.findById(id);
        if (foundWs == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        // 새로 명언, 작가 입력받기
        System.out.printf("명언(기존) : %s", foundWs.getContent());
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.printf("작가(기존) : %s", foundWs.getAuthor());
        System.out.print("명언 : ");
        String author = sc.nextLine();
        // 명언 수정
        wiseSayingService.modify(id, content, author);
        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", 0);
        if (id == 0) {
            System.out.println("번호를 입력해주세요.");
            return;
        }
        WiseSaying foundWs = wiseSayingService.findById(id);  // id로 조회한 명언
        // 해당 id에 대한 명언이 존재하지 않는 경우 예외 처리
        if (foundWs == null) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        // 명언 삭제
        wiseSayingService.remove(id);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

}
