package org.example.domain.wiseSaying.repository;

import org.example.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingRepository {
    static List<String[]> list = new ArrayList<>();

    public static List<String[]> getList() {
        return list;
    }

    public static void delete(int id) {
        list.remove(id - 1);
    }

    public static void post(WiseSaying wiseSaying, int id) {
        String[] arr = new String[3];

        arr[0] = String.valueOf(wiseSaying.getCount());
        arr[1] = wiseSaying.getWiseSaying();
        arr[2] = wiseSaying.getAuthor();

        if (id == 0) {
            list.add(arr);
        } else {
            list.set(id - 1, arr);
        }
    }

    public static String getWiseSayingForId(int id) {
        return list.get(id - 1)[1];
    }

    public static String getAuthorForId(int id) {
        return list.get(id - 1)[2];
    }

    public static int findForId(int id) {
        String[] findId = list.stream()
                .filter(el -> Integer.parseInt(el[0]) == id)
                .findFirst()
                .orElse(new String[]{"0"});

        return Integer.parseInt(findId[0]);
    }
    //데이터의 조회/수정/삭제/생성을 담당
    //
    //스캐너 사용금지, 출력 금지

}
