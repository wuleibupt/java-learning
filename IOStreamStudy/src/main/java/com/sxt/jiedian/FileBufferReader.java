package com.sxt.jiedian;

import java.io.*;

/**
 * 字符流缓冲
 */

public class FileBufferReader {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        System.out.println(property);
        File file = new File("abc.txt");
        Reader reader = null;
        try {
            reader = new FileReader(file);
            char[] flush = new char[10];
            int len = -1;
            while ((len = reader.read(flush)) != -1) {
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader!= null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
