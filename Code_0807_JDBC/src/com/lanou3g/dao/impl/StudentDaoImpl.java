package com.lanou3g.dao.impl;

import com.lanou3g.dao.StudentDao;
import com.lanou3g.entity.Student;
import com.lanou3g.utils.DBUtils;
import com.lanou3g.utils.ResultHandler;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll() {
//        DriverManager.registerDriver(new Driver());
        String sql = "select * from t_students";
        return DBUtils.execute(sql, new StudentQueryRun());

    }

    @Override
    public Student findById(int stuId) {
        String sql = "select * from t_students where stu_id = " + stuId;
        return DBUtils.execute(sql, new StudentQueryRun()).get(0);
    }

    private static class StudentQueryRun implements ResultHandler<Student> {
        @Override
        public List<Student> handle(Statement st, String sql) throws Exception {
            ResultSet resultSet = st.executeQuery(sql);
            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("stu_id");
                String name = resultSet.getString("stu_name");
                Date date = resultSet.getDate("birthday");
                String gender = resultSet.getString("stu_gender");
                Student stu = new Student(id, name, date, gender);
                students.add(stu);
            }
            resultSet.close();
            return students;
        }
    }
}


//statement.handle();
//statement.executeUpdate()
//共同点:都是执行sql语句的
//handle: 可以执行任何SQL语句,但是常用来执行DDL
//executeUpdate : 只能用来执行DML语句,insert/update/delete
//返回值int类型:影响了几条数据
//executeQuery : 只能执行DQL语句  查询
//  DAO   data  access  object
