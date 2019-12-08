package com.sxt.commons;

import org.apache.commons.io.FileUtils;

import java.io.File;

public class commonIoSize {
    public static void main(String[] args) {
        long size = FileUtils.sizeOf(new File("abc.txt"));
        System.out.println(size);

    }
}
