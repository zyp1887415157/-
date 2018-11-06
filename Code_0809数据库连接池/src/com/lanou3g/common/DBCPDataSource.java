package com.lanou3g.common;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBCPDataSource implements ConnectionSource {

    private DataSource source;

    public DBCPDataSource() {

        try {
            Properties properties = new Properties();
            properties.load(new FileReader("src/JDBC.properties"));
            source = BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection get() throws SQLException {
        return source.getConnection();
    }
}
