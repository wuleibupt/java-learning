package com.sxt.tcp;


import java.io.*;
import java.net.Socket;

public class LoginMutliClient {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Client-----");
        Socket client = new Socket("localhost", 8888);
        new Send(client).send();
        new Reveive(client).receive();
        client.close();

    }

    static class Send {
        private Socket client;
        private BufferedReader reader;
        private DataOutputStream dos;
        private String msg;

        public Send(Socket client) {
            reader = new BufferedReader(new InputStreamReader(System.in));
            this.client = client;
            this.msg = init();
            try {
                dos = new DataOutputStream(client.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public String init() {
            try {
                System.out.print("请输入用户名:");
                String name = reader.readLine();
                System.out.print("请输入密码:");
                String passwd = reader.readLine();
                return "uname="+name+"&"+"upwd="+passwd;
            } catch (IOException e) {
                e.printStackTrace();
            }
           return "";
        }

        public void send() {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    static class Reveive {
        private Socket client;
        private DataInputStream dis;

        public Reveive(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        public void receive() {
            String result;
            try {
                result = dis.readUTF();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
