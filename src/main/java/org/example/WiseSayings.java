package org.example;

import java.util.ArrayList;
import java.util.List;

public class WiseSayings {
    static List<String[]> wiseSayingsList = new ArrayList<>();

    private int id;
    private String wiseSayings;
    private String author;

    WiseSayings(int id, String wiseSayings, String author) {
        this.id = id;
        this.wiseSayings = wiseSayings;
        this.author = author;
        WiseSayingsMaker(id, wiseSayings, author);
    }

    public void WiseSayingsMaker(int id, String wiseSayings, String author) {
        String[] list = {String.valueOf(id), wiseSayings, author};
        wiseSayingsList.add(list);
    }

    public static void getWiseSayingsList() {
        for (int i = wiseSayingsList.size() - 1; i >= 0; i--) {
            String[] arr = wiseSayingsList.get(i);
            System.out.printf("%s / %s / %s\n", arr[0], arr[2], arr[1]);
        }
    }
}
