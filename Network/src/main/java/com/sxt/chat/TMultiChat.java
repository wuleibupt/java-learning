package com.sxt.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TMultiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("-----Server-----");
        ServerSocket server = new ServerSocket(8888);
        while (true) {
            Socket client = server.accept();
            new Thread(new Channel(client)).start();
        }


    }

    static class Channel implements Runnable {
        private Socket client;
        private DataInputStream dis;
        private DataOutputStream dos;
        private boolean isRunning;

        public Channel(Socket client) {
            this.client = client;
            try {
                dis = new DataInputStream(client.getInputStream());
                dos = new DataOutputStream(client.getOutputStream());
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

        private void receive() {
            String msg = "";
            try {
                msg = dis.readUTF();
            } catch (IOException e) {
                release();
                e.printStackTrace();
            }
        }


        @Override
        public void run() {

        }

        private void release() {
            this.isRunning = false;
            SxtUtils.close(dis,dos,client);
        }

    }


}
