package com.sxt.tcp;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

public class FileClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Client-----");
        Socket client = new Socket("localhost", 8888);
        FileUtils.copyFile(new File("marvel.jpg"),client.getOutputStream());
        client.close();
    }
}
