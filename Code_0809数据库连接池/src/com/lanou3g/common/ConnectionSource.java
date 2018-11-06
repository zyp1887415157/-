package com.lanou3g.common;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionSource {
    Connection get() throws SQLException;
}
