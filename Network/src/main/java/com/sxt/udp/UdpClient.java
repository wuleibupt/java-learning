package com.sxt.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpClient {
    public static void main(String[] args) throws Exception {
        System.out.println("发送方启动中.....");
        // 1、使用DatagramSocket  指定端口 创建发送端
        DatagramSocket client = new DatagramSocket(8888);
        //2、准备数据 一定转成字节数组
        String data = "好好学习";
        byte[] bytes = data.getBytes();
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost", 6666));
        client.send(packet);
        client.close();
    }
}
