package org.example.domain.wiseSaying.service;

import org.example.domain.wiseSaying.entity.WiseSaying;
import org.example.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {
    static int count = 0;

    public static int write(String wiseSaying, String author) {
        count++;

        WiseSaying wisesaying = new WiseSaying(count, wiseSaying, author);
        WiseSayingRepository.post(wisesaying, 0);
        return count;
    }

    public static List<String[]> list() {
        //구현 완료
        return WiseSayingRepository.getList();
    }

    public static void delete(int id) {
        //구현 완료
        WiseSayingRepository.delete(id);
    }

    public static void modify(int id, String wiseSaying, String author) {
        WiseSaying wisesaying = new WiseSaying(id, wiseSaying, author);
        WiseSayingRepository.post(wisesaying, id);
    }
    //역할 : 순수 비지니스 로직 , 스캐너 사용금지, 출력 금지



}
