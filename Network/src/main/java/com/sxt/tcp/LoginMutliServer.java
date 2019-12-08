package com.sxt.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginMutliServer {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        ServerSocket server = new ServerSocket(8888);
        boolean isRunning =true;
        while (isRunning) {
            Socket client = server.accept();
            System.out.println("一个客户端建立了连接");
            new Thread(new Channel(client)).start();
        }

    }

    static class Channel implements Runnable {
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;

        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                release();
            }
        }

        private String receive() {
            String datas = "";
            try {
                datas = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return datas;
        }

        private void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String uname ="";
            String upwd ="";
            String[] dataArray = receive().split("&");
            for(String info:dataArray) {
                String[] userInfo =info.split("=");
                if(userInfo[0].equals("uname")) {
                    System.out.println("你的用户名为:"+userInfo[1]);
                    uname = userInfo[1];
                }else if(userInfo[0].equals("upwd")) {
                    System.out.println("你的密码为:"+userInfo[1]);
                    upwd = userInfo[1];
                }
            }
            if(uname.equals("shsxt") && upwd.equals("laopei")) { //成功
                send("登录成功，欢迎回来");
            }else { //失败
                send("用户名或密码错误");
            }
            release();
        }

        private void release() {
            // 4、释放资源
            try {
                if(null != dos) {
                    dos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(null != dis) {
                    dis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(null != client) {
                    client.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
