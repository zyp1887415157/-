package com.lanou3g.common;


import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;

public class UnderlineProcessor extends BasicRowProcessor {

    public UnderlineProcessor() {
        super(new GenerousBeanProcessor());
    }
}
