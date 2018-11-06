package com.lanou3g.utils;

public class Utils {
    public static void closeAll(AutoCloseable ... closeables){
        for (AutoCloseable closeable : closeables) {
            // 一定要是 不为空
            if (closeable != null){
                try {
                    closeable.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
