package com.sxt.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class commonIoRead {
    public static void main(String[] args) throws IOException {
        String msg = FileUtils.readFileToString(new File("abc.txt"), "utf-8");
        System.out.println(msg);

        byte[] datas = FileUtils.readFileToByteArray(new File("abc.txt"));
        System.out.println(datas.length);

        List<String> msgs = FileUtils.readLines(new File("abc.txt"), "utf-8");
        for (String str : msgs) {
            System.out.println(str);
        }

        LineIterator it = FileUtils.lineIterator(new File("abc.txt"), "utf-8");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }
}
