package org.example;

import java.util.Scanner;

public class WiseSayingAction {
    public static void register(Scanner sc) {
        System.out.print("명언: ");
        String wiseSaying = sc.nextLine();
        System.out.print("작가: ");
        String author = sc.nextLine();
    }
}
