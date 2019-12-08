package com.sxt.tcp;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        ServerSocket server = new ServerSocket(8888);
        Socket client = server.accept();
        FileUtils.copyToFile(client.getInputStream(), new File("tcp.png"));
        client.close();
        server.close();

    }
}
