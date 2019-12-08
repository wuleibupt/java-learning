package com.sxt.net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IP {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());

        address = InetAddress.getByName("www.hao123.com");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
    }
}
