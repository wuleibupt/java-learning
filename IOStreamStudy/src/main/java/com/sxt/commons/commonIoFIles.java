package com.sxt.commons;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.*;

import java.io.File;
import java.util.Collection;

public class commonIoFIles {
    public static void main(String[] args) {
        Collection<File> files = FileUtils.listFiles(new File("/Users/wulei5/IdeaProjects/java-learning"), EmptyFileFilter.NOT_EMPTY,null);
        for(File file: files) {
            System.out.println(file.getAbsolutePath());
        }

        files = FileUtils.listFiles(new File("/Users/wulei5/IdeaProjects/java-learning"), EmptyFileFilter.NOT_EMPTY, DirectoryFileFilter.INSTANCE);
        for(File file: files) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("---------------------");
        files = FileUtils.listFiles(new File("/Users/wulei5/IdeaProjects/java-learning"), new SuffixFileFilter("java"), DirectoryFileFilter.INSTANCE);
        for(File file: files) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("---------------------");
        files = FileUtils.listFiles(new File("/Users/wulei5/IdeaProjects/java-learning"), FileFilterUtils.and(new SuffixFileFilter("java"), EmptyFileFilter.NOT_EMPTY), DirectoryFileFilter.INSTANCE);
        for(File file: files) {
            System.out.println(file.getAbsolutePath());
        }


    }
}
