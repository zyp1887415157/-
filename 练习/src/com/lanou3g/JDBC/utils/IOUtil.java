package com.lanou3g.JDBC.utils;

public class IOUtil {
    public static void closeAll(AutoCloseable ...autoCloseables){
        for (AutoCloseable autoCloseable : autoCloseables) {
            if (autoCloseable!=null){
                try {
                    autoCloseable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
