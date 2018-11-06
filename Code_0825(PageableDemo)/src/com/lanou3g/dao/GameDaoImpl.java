package com.lanou3g.dao;

import com.lanou3g.bean.GameBean;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.BasicRowProcessor;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.GenerousBeanProcessor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

public class GameDaoImpl implements GameDao {
    private ComboPooledDataSource source = new ComboPooledDataSource();

    @Override
    public int queryTotalCount() throws Exception {
        Connection conn = source.getConnection();
        try {
            String sql = "select count(game_id) as count from Games";
            QueryRunner runner = new QueryRunner();
            Map<String, Object> map = runner.query(conn, sql, new MapHandler());
            int count = Integer.parseInt(String.valueOf(map.get("count")));
            return count;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }

    @Override
    public List<GameBean> queryLimit(int offset, int count) throws Exception {
        Connection conn = source.getConnection();
        try {
            String sql = "select * from Games limit ?,?";
            QueryRunner runner = new QueryRunner();
            Object[] params = {offset, count};
            BeanListHandler<GameBean> handler =
                    new BeanListHandler<>(GameBean.class, new BasicRowProcessor(new GenerousBeanProcessor()));
            List<GameBean> items = runner.query(conn, sql, handler, params);
            System.out.println(sql);
            return items;
        } finally {
            DbUtils.closeQuietly(conn);
        }
    }
}
