package com.sxt.net;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.net.MalformedURLException;
import java.net.URL;

public class Spider {
    public static void main(String[] args) throws Exception {
        String datas = IOUtils.toString(new URL("https://www.jd.com"), "utf-8");
        System.out.println(datas);
    }
}
