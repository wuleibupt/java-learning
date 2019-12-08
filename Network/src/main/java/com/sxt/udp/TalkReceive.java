package com.sxt.udp;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive  implements  Runnable{
    DatagramSocket server;
    private String from;

    public TalkReceive(int port, String from) {
        this.from = from;
        try {
            server = new DatagramSocket(port);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            byte[] buff = new byte[10 * 1024];
            DatagramPacket packet = new DatagramPacket(buff, 0, buff.length);
            try {
                server.receive(packet);
                byte[] data = packet.getData();
                String msg = new String(data, 0, packet.getLength());
                System.out.println(msg);
                if (msg.equals("bye")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        server.close();

    }
}
