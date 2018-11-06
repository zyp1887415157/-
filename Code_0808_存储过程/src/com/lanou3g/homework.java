package com.lanou3g;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.lanou3g.bean.ScoreBean;
import com.lanou3g.bean.StudentBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.io.FileWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class homework {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/my_db";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);


        QueryRunner runner1 = new QueryRunner();
        String sql = "select * from t_students";
        String sql2 = "select * from t_score where stu_id = ?";
        List<StudentBean> query = runner1.query(conn, sql, new BeanListHandler<>(StudentBean.class, new UnderlineProcessor()));
        for (StudentBean studentBean : query) {
            List<ScoreBean> query1 = runner1.query(conn, sql2, new BeanListHandler<>(ScoreBean.class, new UnderlineProcessor()), studentBean.getStuId());
            studentBean.setScoreBeans(query1);
        }
        System.out.println(query);

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        Writer writer = new FileWriter("json.json");
        String s = gson.toJson(query);
        writer.write(s);
        writer.close();
    }
}
