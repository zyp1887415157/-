package com.lanou3g;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

import java.io.FileWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ComboPooledDataSource source = new ComboPooledDataSource();
        Connection conn = source.getConnection();
        String sql = "select * from t_students";
        QueryRunner runner = new QueryRunner();
        List<StudentBean> query = runner.query(conn, sql, new BeanListHandler<>(StudentBean.class, new Conversion()));
        StringBuilder sb = new StringBuilder();
        String preHtml = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n"+"<table border=\"2\" >";
        String s = "<tr>\n"+
        "<td>id</td>"+
        "<td>名字</td>\n"+
        "<td>生日</td>\n"+
        "<td>性别</td>\n"+
    "</tr>";

        sb.append(preHtml);
        sb.append(s);
        for (StudentBean studentBean : query) {
            int stuId = studentBean.getStuId();
            String stuName = studentBean.getStuName();
            Date birthday = studentBean.getBirthday();
            String stuGender = studentBean.getStuGender();
            sb.append("<tr>" + "\n")
                    .append("<td>" + stuId + "</td>" + "\n")
                    .append("<td>" + stuName + "</td>" + "\n")
                    .append("<td>" + birthday + "</td>" + "\n")
                    .append("<td>" + stuGender + "</td>" + "\n")
                    .append("</tr>" + "\n");
        }
        String footHtml = "</table>\n"+"</body>\n" +
                "</html>";
        sb.append(footHtml);
        Writer writer = new FileWriter("AA.html");
        writer.write(sb.toString());
        writer.close();
    }
}
