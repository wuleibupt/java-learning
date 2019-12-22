package com.sxt.server.core;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;
    private boolean isRunning;

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    public void start() {
        try {
            this.serverSocket = new ServerSocket(8080);
            isRunning = true;
            receive();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("服务器启动失败....");
            stop();
        }
    }

    public void receive() {
        while (isRunning) {
            try {
                Socket client = this.serverSocket.accept();
                System.out.println("一个客户端建立了连接....");
                new Thread(new Dispatcher(client)).start();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("客户端错误");
            }
        }
    }

    public void stop() {
        isRunning = false;
        try {
            this.serverSocket.close();
            System.out.println("服务器已停止");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
