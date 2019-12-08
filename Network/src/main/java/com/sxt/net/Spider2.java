package com.sxt.net;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Spider2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://www.dianping.com");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.81 Safari/537.36");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String msg = null;
        while ((msg = reader.readLine()) != null) {
            System.out.println(msg);
        }
    }
}
