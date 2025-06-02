package org.example.domain.wiseSaying.entity;

//후에 id를 기반으로 리스트를 찾는 것도 여기서 한다.

public class WiseSaying{
    private int count;
    private String wiseSaying;
    private String author;

    public WiseSaying(int count, String wiseSaying, String author) {
        this.count = count;
        this.wiseSaying = wiseSaying;
        this.author = author;
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

}
//배열을 전달해줘서 레포지터리에서 등록하게 한다.