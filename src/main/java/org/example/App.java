package org.example;

import org.example.domain.system.controller.SystemController;
import org.example.domain.wiseSaying.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static void run() {
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령: ");
            String cmd = sc.nextLine().trim();
            Rq rq = new Rq(cmd);

            if (rq.getActionName().equals("종료")) {
                SystemController.exit();
                break;
            } else {
                new WiseSayingController(rq, sc);
                //컨트롤러에 rq와 스캐너를 전달해준다. rq는 명령과 아이디, 쿼리를 가지고 있다.
            }
        }
    }
}
