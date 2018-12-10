package com.lanou.bookstore.user.util;



import org.junit.Test;

import java.util.UUID;

/**
 * Created by dllo on 18/5/15.
 */
public class TestUUID {

    public static String getRandomString() {
        String uuid = UUID.randomUUID().toString()//转成字符串
                .replace("-", "")//去掉"-"
                .toUpperCase();//转成大写字母
        return uuid;
    }

}
