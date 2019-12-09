package com.sxt.chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements Runnable{
    private Socket client;
    private BufferedReader console;
    private DataOutputStream dos;
    private boolean isRunning;

    public Send(Socket client) {
        this.client = client;
        this.isRunning = true;
        console = new BufferedReader(new InputStreamReader(System.in));
        try {
            dos = new DataOutputStream(client.getOutputStream());
        } catch (IOException e) {
            release();
            e.printStackTrace();
        }

    }

    @Override
    public void run() {
        while (isRunning) {
            String msg = getStrFromConsole();
            if (!msg.equals("")) {
                send(msg);
            }
        }
    }

    private String getStrFromConsole() {
        try {
            return console.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            release();
        }
        return "";
    }

    private void send(String msg) {
        try {
            dos.writeUTF(msg);
            dos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            release();
        }
    }

    private void release() {
        this.isRunning = true;
        SxtUtils.close(dos, client);
    }

}
