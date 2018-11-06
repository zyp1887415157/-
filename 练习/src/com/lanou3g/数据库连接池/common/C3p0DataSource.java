package com.lanou3g.数据库连接池.common;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class C3p0DataSource implements ConnectionSource {

    private ComboPooledDataSource source = new ComboPooledDataSource();
    @Override
    public Connection get() throws SQLException {
        return source.getConnection();
    }
}
