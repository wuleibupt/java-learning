package com.sxt.jiedian;

import java.io.*;

/**
 * 字节流缓冲
 */

public class FileBufferInput {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        System.out.println(property);
        File file = new File("abc.txt");
        InputStream is = null;
        try {
            is = new FileInputStream(file);
            byte[] flush = new byte[1024*10];
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
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
