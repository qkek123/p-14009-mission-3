package org.example.domain.wiseSaying.entity;

//후에 id를 기반으로 리스트를 찾는 것도 여기서 한다.

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class WiseSaying{
    private int count;
    private String wiseSaying;
    private String author;

    public WiseSaying(int count, String wiseSaying, String author) {
        this.count = count;
        this.wiseSaying = wiseSaying;
        this.author = author;

        String fileName = "db/wiseSaying/lastId.txt";
        String content = String.valueOf(count);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            bw.write(content);
        } catch (Exception e) {
            System.out.println("파일 저장 실패");
        }
    }

    public int getCount() {
        return count;
    }

    public String getWiseSaying() {
        return wiseSaying;
    }

    public String getAuthor() {
        return author;
    }

    public static void save(String content) {
        String fileName = "db/wiseSaying/data.json";
        new File("db/wiseSaying").mkdirs();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, false))) {
            bw.write(content);
        } catch (Exception e) {
            System.out.println("파일 저장 실패");
        }
    }

}
//배열을 전달해줘서 레포지터리에서 등록하게 한다.