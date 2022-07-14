package com.ll.exam.repository;

import com.ll.exam.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int wiseSayingLastId;   // 가장 마지막으로 추가된 명언 글 번호
    private List<WiseSaying> wiseSayings;   // 명언 리스트

    public WiseSayingRepository() {
        wiseSayingLastId = 0;
        wiseSayings = new ArrayList<>();
    }

    public WiseSaying add(String content, String author) {
        int id = ++wiseSayingLastId;
        WiseSaying wiseSaying = new WiseSaying(id, content, author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    public WiseSaying findById(int id) {
        for (WiseSaying ws : wiseSayings) {
            if (ws.getId() == id)
                return ws;
        }
        return null;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public void modify(int id, String content, String author) {
        WiseSaying wiseSaying = findById(id);
        wiseSaying.setContent(content);
        wiseSaying.setAuthor(author);
    }

    public void remove(int id) {
        WiseSaying wiseSaying = findById(id);
        wiseSayings.remove(wiseSaying);
    }
}
