package com.sxt.deal;

import java.io.*;

public class BufferReader {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("abc.txt"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
