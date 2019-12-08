package com.sxt.udp;


import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpSever {
    public static void main(String[] args) throws Exception {
        System.out.println("收方启动中.....");
        DatagramSocket server = new DatagramSocket(6666);
        byte[] buffer = new byte[10 * 1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        server.receive(packet);
        byte[] data = packet.getData();
        System.out.println(packet.getLength());
        System.out.println(new String(data, 0, packet.getLength()));
        server.close();
    }
}
