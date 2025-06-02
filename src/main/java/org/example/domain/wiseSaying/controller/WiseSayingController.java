package org.example.domain.wiseSaying.controller;

import org.example.Rq;
import org.example.domain.wiseSaying.repository.WiseSayingRepository;
import org.example.domain.wiseSaying.service.WiseSayingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    //역할 : 고객의 명령을 입력받고 적절을 응답을 표현
    //이 단계에서는 스캐너 사용가능
    //이 단계에서는 출력 사용가능
    //역할 : 명언에 관련된 응대

    Scanner sc;

    public WiseSayingController(Rq rq, Scanner sc) {
        this.sc = sc;

        switch (rq.getActionName()) {
            case "등록" -> actionWrite();
            case "목록" -> actionList();
            case "삭제" -> actionDelete(rq.getIdName());
            case "수정" -> actionModify(rq.getIdName());
        }

    }

    private void actionModify(int id) {
        if (id == -1) {
            System.out.println("잘못된 형식의 id입니다.");
        } else if (WiseSayingRepository.findForId(id) != id) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
        } else {
            String[] arr = new String[3];

            System.out.print("명언(기존): ");
            System.out.println(WiseSayingRepository.getWiseSayingForId(id));
            System.out.print("명언: ");
            String wiseSaying = sc.nextLine();
            System.out.print("작가(기존): ");
            System.out.println(WiseSayingRepository.getAuthorForId(id));
            System.out.print("작가: ");
            String author = sc.nextLine();
            System.out.printf("%d번 명언이 수정되었습니다.\n", id);
            WiseSayingService.modify(id, wiseSaying, author);
        }
    }

    private void actionDelete(int id) {
        if (id == -1) {
            System.out.println("잘못된 형식의 id입니다.");
        } else if (WiseSayingRepository.findForId(id) != id){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
        } else {
            WiseSayingService.delete(id);
        }

    }

    private void actionList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");

        List<String[]> list = new ArrayList<>(WiseSayingService.list());
        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i)[0] + " / " + list.get(i)[2] +" / " + list.get(i)[1]);
        }
    }

    private void actionWrite() {
        System.out.print("명언: ");
        String wiseSaying = sc.nextLine();
        System.out.print("작가: ");
        String author = sc.nextLine();

        int count = WiseSayingService.write(wiseSaying, author);

        System.out.printf("%d번 명언이 등록되었습니다.\n", count);
    }

}
