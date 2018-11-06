package com.lanou3g;

import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.GenerousBeanProcessor;

public class Conversion extends BasicRowProcessor {
    public Conversion() {
        super(new GenerousBeanProcessor());
    }
}
