package com.ll.exam.service;

import com.ll.exam.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingService {
    private int wiseSayingLastId;   // 가장 마지막으로 추가된 명언 글 번호
    private List<WiseSaying> wiseSayings;   // 명언 리스트

    public WiseSayingService() {
        wiseSayingLastId = 0;
        wiseSayings = new ArrayList<>();
    }

    // 명언 저장
    public WiseSaying write(String content, String author) {
        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    // id로 명언 조회
    public WiseSaying findById(int id) {
        for (WiseSaying ws : wiseSayings) {
            if (ws.getId() == id)
                return ws;
        }
        return null;
    }

    // 모든 명언 조회
    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    // id로 명언 수정
    public void modify(int id, String content, String author) {
        WiseSaying wiseSaying = findById(id);
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }

    // id로 명언 삭제
    public void remove(int id) {
        WiseSaying wiseSaying = findById(id);
        wiseSayings.remove(wiseSaying);
    }
}
