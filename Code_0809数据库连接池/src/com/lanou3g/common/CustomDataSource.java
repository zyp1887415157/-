package com.lanou3g.common;

import com.lanou3g.db.LanouDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class CustomDataSource implements ConnectionSource {
    @Override
    public Connection get() throws SQLException {
        return LanouDataSource.getInstance().getConnection();
    }
}
