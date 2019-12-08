package com.sxt.jiedian;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteArrayInput {
    public static void main(String[] args) {
        byte[] datas = "hello world".getBytes();
        InputStream is = null;
        is = new ByteArrayInputStream(datas);
        byte[] flush = new byte[10*1024];
        int len = -1;
        try {
            while ((len = is.read(flush)) != -1) {
                String msg = new String(flush, 0, len);
                System.out.println(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
