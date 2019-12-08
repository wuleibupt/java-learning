package com.sxt.jiedian;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteArrayOutput {
    public static void main(String[] args) {
        byte[] dest = null;
        ByteArrayOutputStream os = null;
        os = new ByteArrayOutputStream();
        String msg = "hello world";
        byte[] data = msg.getBytes();
        try {
            os.write(data,0,data.length);
            os.flush();
            dest = os.toByteArray();
            System.out.println(new String(dest, 0, dest.length));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
}
