package com.sxt.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

public class TMultiChat {

    private static CopyOnWriteArrayList<Channel> all = new CopyOnWriteArrayList<>();

    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket client = server.accept();
            Channel c = new Channel(client);
            all.add(c);
            new Thread(c).start();
        }


    }

    static class Channel implements Runnable {
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning;
        private String name;

        public Channel(Socket client) {
            this.client = client;

            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
                this.isRunning =true;
                this.name = receive();
                this.send("欢迎你的到来");
            } catch (IOException e) {
                release();
                e.printStackTrace();
            }
        }

        private void send(String msg) {
            try {
                dos.writeUTF(msg);
                dos.flush();
            } catch (IOException e) {
                release();
                e.printStackTrace();
            }
        }

        private void sendOthers(String msg, boolean isSys) {
            for (Channel c : all) {
                if (c == this) {
                    continue;
                }
                if (!isSys) {
                    c.send(this.name +"对所有人说:"+msg);
                }else {
                    c.send(msg);
                }
            }
        }

        private String receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                release();
                e.printStackTrace();
            }
            return msg;
        }


        @Override
        public void run() {
            while (isRunning) {

                String msg = receive();
                if (!msg.equals("")) {
                    sendOthers(msg, false);
                }
            }
        }

        private void release() {
            this.isRunning = false;
            SxtUtils.close(dis,dos,client);
        }

    }


}
