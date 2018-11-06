package com.lanou3g.JDBC.utils;

import java.sql.Statement;
import java.util.List;

public interface ResultHandler<T> {

    List<T> handle(Statement st,String sql) throws Exception;
}
