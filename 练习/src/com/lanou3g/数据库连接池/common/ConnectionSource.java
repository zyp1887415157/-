package com.lanou3g.数据库连接池.common;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionSource {
    Connection get() throws SQLException;
}
