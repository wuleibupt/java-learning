package com.sxt.deal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class InputStreamReadBaidu {
    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(), "utf-8"));
            String msg = "";
            while ((msg = reader.readLine()) != null) {
                msg = reader.readLine();
                System.out.println(msg);
            }

        }catch (Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
