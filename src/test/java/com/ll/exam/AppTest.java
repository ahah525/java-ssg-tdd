package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
    @Test
    public void 프로그램_시작시_타이틀_츨력_그리고_종료() {
        Scanner sc = TestUtil.genScanner("종료");
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();  // 실행

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);
        // 프로그램 시작 후, 종료 입력시 출력되어야할 결과가 맞는지 검증
        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령) "));
    }

    @Test
    public void 등록을_하면_명언과_작가를_물어본다() {
        Scanner sc = TestUtil.genScanner("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                종료
                """);
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();

        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);
        // 등록 입력시 명언, 작가가 나오는지 검증
        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
    }

    @Test
    public void 테스트() {
        assertTrue(1 == 1);
        assertEquals(1, 1);
    }

    @Test
    public void 스캐너에_키보드가_아닌_문자열을_입력으로_설정() {
        Scanner sc = TestUtil.genScanner("안녕");
        String cmd = sc.nextLine().trim();// 한줄 읽어서 앞뒤 공백 제거
        // "안녕"이 스캐너에 입력된 문자열이 맞는지 검증
        assertEquals("안녕", cmd);
    }

    @Test
    public void 출력을_모니터에_하지_않고_문자열로_얻기() {
        // 모니터에 출력할 문자열이 모두 output에 담김
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");
        String rs = output.toString();
        TestUtil.clearSetOutToByteArray(output);
        // output에 담긴 문자열이 "안녕"이 맞는지 검증
        assertEquals("안녕", rs);
    }

    @Test
    public void 문자열을_파일에_저장() {
        // 폴더 생성 후, 해당 path 파일에 body 쓰기
        Util.file.mkdir("test_data");
        Util.file.saveToFile("test_data/1.json", "안녕");
        String body = Util.file.readFromFile("test_data/1.json");
        // "안녕"과 파일에 저장된 내용이 동일한지 검증
        assertEquals("안녕", body);
    }
}
