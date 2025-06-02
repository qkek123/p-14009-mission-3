package org.example;

public class Rq {
//커맨드를 깔끔하게 나눠서 id와 명령으로 분리한다.
    //getid와 getcommand, get쿼리.. 등등
    private static String command;
    private static int id;

    public Rq(String cmd) {
        //잘 나눠서 커맨드는 등록하는데
        //만약 id가 잘못된 값이라면 id를 -1로 등록한다.
        String[] arr = cmd.split("\\?");

        command = arr[0];
        if (arr.length == 2) {
            try {
                id = Integer.parseInt(arr[1].replace("id=", ""));
            } catch (Exception e) {
                id = -1;
            }
        } else {
            id = -1;
        }
    }

    public String getActionName() {
        return command;
    }

    public int getIdName() {
        return id;
    }
}
