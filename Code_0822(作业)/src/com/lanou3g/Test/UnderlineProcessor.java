package com.lanou3g.Test;


import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;

public class UnderlineProcessor extends BasicRowProcessor {

    public UnderlineProcessor() {
        super(new GenerousBeanProcessor());
    }
}
