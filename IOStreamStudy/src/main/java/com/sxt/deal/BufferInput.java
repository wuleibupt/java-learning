package com.sxt.deal;

import java.io.*;

public class BufferInput {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        InputStream is = null;
        try {
            is = new BufferedInputStream(new FileInputStream("abc.txt"));
            byte[] flush = new byte[10 * 1024];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                System.out.println(new String(flush, 0, len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
