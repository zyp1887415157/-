package com.lanou3g;

public class NumberNotBeNegativeException extends RuntimeException {

    public NumberNotBeNegativeException(int x, int y) {
        super("传入的参数必须为正数,傻屌传入的x="+x+",y="+y);
    }
}
