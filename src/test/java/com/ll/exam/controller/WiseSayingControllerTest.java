package com.ll.exam.controller;

import com.ll.exam.AppTestRunner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WiseSayingControllerTest {
    @Test
    public void 프로그램_시작시_타이틀_츨력_그리고_종료() {
        String rs = AppTestRunner.run("종료");

        // 프로그램 시작 후, 종료 입력시 출력되어야할 결과가 맞는지 검증
        assertTrue(rs.contains("== 명언 SSG =="));
        assertTrue(rs.contains("명령) "));
    }

    @Test
    public void 등록을_하면_명언과_작가를_물어본다() {
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                종료
                """);
        // 등록 입력시 명언, 작가가 나오는지 검증
        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
    }

    @Test
    public void 등록을_하면_생성된_명언의_번호가_출력되어야_한다() {
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                등록
                나에게 불가능이란 없다.
                나폴레옹
                종료
                """);
        // 등록 2번 수행 시, 생성된 명언의 번호가 맞게 출력되는지 검증
        assertTrue(rs.contains("1번 명언이 등록되었습니다."));
        assertTrue(rs.contains("2번 명언이 등록되었습니다."));

    }

    @Test
    public void 등록_후_목록에서_확인할_수_있어야_한다() {
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                등록
                나에게 불가능이란 없다.
                나폴레옹
                목록
                종료
                """);
        // 목록입력시 결과가 맞게 나오는지 검증
        assertTrue(rs.contains("번호 / 작가 / 명언"));
        assertTrue(rs.contains("----------------------"));
        assertTrue(rs.contains("2 / 나폴레옹 / 나에게 불가능이란 없다."));
        assertTrue(rs.contains("1 / 이순신 / 나의 죽음을 적들에게 알리지 말라"));
    }

    @Test
    public void 명언을_삭제할_수_있다() {
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                등록
                나에게 불가능이란 없다.
                나폴레옹
                삭제?id=1
                목록
                삭제?id=1
                종료
                """);
        // 1번 명언 삭제후 결과가 맞는지 검증
        assertTrue(rs.contains("1번 명언이 삭제되었습니다."));
        assertTrue(rs.contains("2 / 나폴레옹 / 나에게 불가능이란 없다."));
        assertFalse(rs.contains("1 / 이순신 / 나의 죽음을 적들에게 알리지 말라"));   // 1번 명언은 없어야 함
        assertTrue(rs.contains("1번 명언은 존재하지 않습니다."));
    }

    @Test
    public void 명언을_수정할_수_있다() {
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                등록
                나에게 불가능이란 없다.
                나폴레옹
                목록
                수정?id=1
                나의 죽음을 적들에게 알리지 마라!
                이순신장군
                목록
                종료
                """);
        // 1번 명언 삭제 후 결과가 맞는지 검증
        assertTrue(rs.contains("1 / 이순신 / 나의 죽음을 적들에게 알리지 말라"));
        assertTrue(rs.contains("1 / 이순신장군 / 나의 죽음을 적들에게 알리지 마라!"));
    }
}