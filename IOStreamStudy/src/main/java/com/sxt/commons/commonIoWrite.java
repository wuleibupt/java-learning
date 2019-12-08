package com.sxt.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class commonIoWrite {
    public static void main(String[] args) throws IOException {
        FileUtils.write(new File("output.txt"), "学习","utf-8");
        FileUtils.writeStringToFile(new File("output.txt"), "好好","utf-8",true);
        FileUtils.writeByteArrayToFile(new File("output.txt"), "天天".getBytes(StandardCharsets.UTF_8), true);

        List<String> list = new ArrayList<>();
        list.add("马云");
        list.add("马化腾");
        FileUtils.writeLines(new File("output.txt"), list,"...", true);
    }
}
