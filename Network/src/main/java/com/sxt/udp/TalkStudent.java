package com.sxt.udp;

public class TalkStudent {
    public static void main(String[] args) {
        new Thread(new TalkReceive(8888, "老师")).start();
        new Thread(new TalkSend(7777, "localhost", 9999)).start();
    }
}
