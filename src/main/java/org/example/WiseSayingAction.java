package org.example;

import java.util.Scanner;

public class WiseSayingAction {
    static int count = 0;

    public static void register(Scanner sc) {
        System.out.print("명언: ");
        String wiseSaying = sc.nextLine();
        System.out.print("작가: ");
        String author = sc.nextLine();
        count++;
        System.out.printf("%d번 명언이 등록되었습니다.\n", count);
    }
}
