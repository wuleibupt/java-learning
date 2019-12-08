package com.sxt.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

public class commonIoCopy {
    public static void main(String[] args) throws IOException {
        FileUtils.copyFile(new File("abc.txt"), new File("p-abc.txt"));
        FileUtils.copyFileToDirectory(new File("abc.txt"), new File("lib"));
        FileUtils.copyDirectoryToDirectory(new File("lib"), new File("lib2"));
        FileUtils.copyDirectory(new File("lib"), new File("lib2"));
        FileUtils.copyURLToFile(new URL("https://pic2.zhimg.com/v2-7d01cab20858648cbf62333a7988e6d0_qhd.jpg"), new File("marvel.jpg"));
        String msg = IOUtils.toString(new URL("http://www.163.com"), "gbk");
        System.out.println(msg);
    }
}
