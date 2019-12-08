package com.sxt.deal;

import java.io.*;

public class BufferWriter {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("output.txt"));
            writer.write("hello world");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
