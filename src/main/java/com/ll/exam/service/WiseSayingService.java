package com.ll.exam.service;

import com.ll.exam.WiseSaying;
import com.ll.exam.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {
    private WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        wiseSayingRepository = new WiseSayingRepository();
    }

    // 명언 저장
    public WiseSaying write(String content, String author) {
        // 명언 메모리에 저장
        return wiseSayingRepository.add(content, author);
    }

    // id로 명언 조회
    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    // 모든 명언 조회
    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    // id로 명언 수정
    public void modify(int id, String content, String author) {
        wiseSayingRepository.modify(id, content, author);
    }

    // id로 명언 삭제
    public void remove(int id) {
        wiseSayingRepository.remove(id);
    }
}
