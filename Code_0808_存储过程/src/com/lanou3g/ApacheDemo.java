package com.lanou3g;

import com.lanou3g.bean.StudentBean;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public class ApacheDemo {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/my_db";
        String user = "root";
        String password = "123456";
        Connection conn = DriverManager.getConnection(url, user, password);


        QueryRunner runner = new QueryRunner();
        Object[] params = {1, 1};
        int num = runner.update(conn, "delete from t_score where stu_id = ? and course_id = ? ", params);

        if (num > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }


        //-------------------------分割线-------------------------
        // 查询多条数据  BeanListHandler
        QueryRunner runner1 = new QueryRunner();
//        String sql = "select stu_id as stuId,stu_name as stuName,birthday,stu_gender as stuGender from t_students where stu_gender = ?";
        String sql = "select * from t_students where stu_gender = ?";
        Object[] p = {"男"};
//        RowProcessor rp = new UnderlineProcessor();
        List<StudentBean> beanList = runner1.query(conn, sql, new BeanListHandler<>(StudentBean.class, new UnderlineProcessor()), p);
        beanList.forEach(System.out::println);

        //ResultSetHandler  查询单条数据  BeanHandler

        String sql1 = "select * from t_students where stu_id = ?";
        QueryRunner runner2 = new QueryRunner();
        Object[] o1 = {6};
        StudentBean stu = runner2.query(conn, sql1, new BeanHandler<>(StudentBean.class, new UnderlineProcessor()), o1);
        System.out.println(stu);

        DbUtils.close(conn);
//        DbUtils.commitAndCloseQuietly(conn);
    }
}
