package com.sxt.udp;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpFileClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中.....");
        DatagramSocket client = new DatagramSocket(8888);
        byte[] datas = FileUtils.readFileToByteArray(new File("logo.png"));
        DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 6666));
        client.send(packet);
        client.close();
    }

}
