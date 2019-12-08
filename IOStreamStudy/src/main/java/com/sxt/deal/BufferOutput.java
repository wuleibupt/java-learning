package com.sxt.deal;

import java.io.*;

public class BufferOutput {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        OutputStream os = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream("abc.txt"));
            byte[] datas = "hello world".getBytes();
            os.write(datas,0, datas.length);
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } 
            }
        }
    }
}
