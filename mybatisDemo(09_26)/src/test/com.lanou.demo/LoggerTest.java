package com.lanou.demo;

import org.apache.log4j.Logger;
import org.junit.Test;

public class LoggerTest {

    @Test
    public void logTest(){
        Logger logger = Logger.getLogger(LoggerTest.class);//获取logger对象
        logger.error("Error 日志");
        logger.warn("warn 日志");
        logger.info("info 日志");
        logger.debug("debug 日志");
    }
}
