package com.sxt.udp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable{
    private BufferedReader reader;
    DatagramSocket client;
    private String toIP;
    private int toPort;

    public TalkSend(int port, String toIP, int toPort) {
        this.toIP = toIP;
        this.toPort = toPort;
        try {
            client = new DatagramSocket(port);
            reader = new BufferedReader(new InputStreamReader(System.in));
        } catch (SocketException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void run() {
        String msg = null;
        while (true) {
            try {
                msg = reader.readLine();
                byte[] bytes = msg.getBytes();
                DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress(this.toIP, this.toPort));
                client.send(packet);
                if (msg.equals("byte")) {
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        client.close();

    }
}
