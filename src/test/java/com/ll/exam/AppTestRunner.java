package com.ll.exam;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {
    public static String run(String input) {
        // 스캐너를 얻는다
        // 키보드 입력이 아닌, 문자열을 입력으로 하는 스캐너가 생성된다
        Scanner sc = TestUtil.genScanner(input);
        // 평소에는 표준출력(System.out)이 모니터를 향하고 있다
        // 그것을 특정 바이트스트림에 쌓이도록 변경한다
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();  // 실행

        // 바이트스트림이 여태까지 모아놓은 출력들을
        String rs = output.toString();
        // System.out이 다시 모니터를 향하도록 변경한다
        TestUtil.clearSetOutToByteArray(output);

        return rs;
    }
}
