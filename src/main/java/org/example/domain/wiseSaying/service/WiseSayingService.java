package org.example.domain.wiseSaying.service;

import org.example.domain.wiseSaying.entity.WiseSaying;
import org.example.domain.wiseSaying.repository.WiseSayingRepository;

import java.io.BufferedReader;
import java.io.FileReader;
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

    public static void build() {
        //레포지터리에서 리스트 가져오기.
        List<String[]> list = WiseSayingRepository.getList();
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < list.size(); i++) {
            String content = "";

            if (i == list.size() - 1) {
                content = String.format("""
                    {
                        "id": %s,
                        "content": "%s",
                        "author": "%s"
                    }
                ]
                """, list.get(i)[0], list.get(i)[1], list.get(i)[2]);
                sb.append(content);
            } else {
                content = String.format("""
                    
                    {
                        "id": %s,
                        "content": "%s",
                        "author": "%s"
                    },
                """, list.get(i)[0], list.get(i)[1], list.get(i)[2]);
                sb.append(content);
            }
        }

        WiseSaying.save(sb.toString());

    }
    //역할 : 순수 비지니스 로직 , 스캐너 사용금지, 출력 금지



}
