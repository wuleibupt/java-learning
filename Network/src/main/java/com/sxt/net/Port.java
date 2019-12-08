package com.sxt.net;

import java.net.InetSocketAddress;

public class Port {
    public static void main(String[] args) {
        InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
        InetSocketAddress socketAddress1 = new InetSocketAddress("localhost", 9000);
        System.out.println(socketAddress.getHostName());
        System.out.println(socketAddress.getAddress());
        System.out.println(socketAddress1.getHostName());
        System.out.println(socketAddress1.getPort());
    }
}
