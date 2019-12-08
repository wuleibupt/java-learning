package com.sxt.jiedian;

import java.io.*;

/**
 * 字节流
 */

public class FileBufferOutput {
    public static void main(String[] args) {
        String property = System.getProperty("user.dir");
        System.out.println(property);
        File file = new File("ouput.txt");
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            String msg = "hello world1";
            byte[] datas = msg.getBytes();
            os.write(datas);
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

    /**
     * 字符流缓冲
     */

    public static class FileBufferWriter {
        public static void main(String[] args) {
            String property = System.getProperty("user.dir");
            System.out.println(property);
            File file = new File("abc.txt");
            Writer writer = null;
            try {
                writer = new FileWriter(file);
                String msg = "hello world";
                char[] chars = msg.toCharArray();
    //            writer.write(chars, 0, chars.length);

    //            writer.write(msg);
                writer.append("add").append("shub");
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (writer!= null) {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }
}
