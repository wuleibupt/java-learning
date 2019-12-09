package com.sxt.chat;

import java.io.Closeable;
import java.io.IOException;

public class SxtUtils {
    public static void close(Closeable... targets) {
        for (Closeable taget: targets) {
            try {
                if (taget != null) {
                    taget.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
