package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
    }

    // 실행 메서드
    public void run() {
        System.out.println("== 명언 SSG ==");

        outer:
        while (true) {
            System.out.println("명령) ");
            String cmd = sc.nextLine();

            switch (cmd) {
                case "종료":
                    break outer;    // outer 라벨이 붙은 곳에서 break
            }
        }
    }
}
