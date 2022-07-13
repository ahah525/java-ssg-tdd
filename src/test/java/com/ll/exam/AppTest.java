package com.ll.exam;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {
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
