package com.sxt.net;


import java.net.MalformedURLException;
import java.net.URL;

public class Url {
    public static void main(String[] args) throws MalformedURLException {
        URL url = new URL("http://www.baidu.com:80/index.html?uname=shsxt&age=18#a");
        System.out.println("协议：" + url.getProtocol());
        System.out.println("域名|ip:" + url.getHost());
        System.out.println("端口：" + url.getPort());
        System.out.println("请求资源1：" + url.getFile());
        System.out.println("请求资源2：" + url.getPort());
        System.out.println("参数：" + url.getQuery());
        System.out.println("描点" + url.getRef());
    }
}
