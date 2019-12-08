package com.sxt.udp;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpFileServer {
    public static void main(String[] args) throws Exception {
        System.out.println("接收方启动中.....");
        DatagramSocket server = new DatagramSocket(6666);
        byte[] buffer = new byte[60 * 1024];
        DatagramPacket packet = new DatagramPacket(buffer, 0, buffer.length);
        server.receive(packet);
        byte[] data = packet.getData();
        FileUtils.writeByteArrayToFile(new File("p-logo.png"), data, 0, packet.getLength());
        server.close();
    }
}
