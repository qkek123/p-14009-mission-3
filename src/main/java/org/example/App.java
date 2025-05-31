package org.example;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령: ");
            String cmd = sc.nextLine().trim();
            if (cmd.equals("종료")) {
                sc.close();
                break;
            }
        }
    }
}
