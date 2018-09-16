package com.jerry.dao;

import com.jerry.domain.Student;
import com.jerry.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
StudentDAO访问接口实现类，通过最原始的JDBC的方式操作
 */
public class StudentDAOImpl implements StudentDAO {

    @Override
    public List<Student> query() {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
        connection = JDBCUtil.getConnection();
        String sql  = "select * from student";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery();
        Student student = null;
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            student = new Student();
            student.setId(id);
            student.setName(name);
            student.setAge(age);
            students.add(student);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }

        return students;
    }


    @Override
    public void save(Student student) {
        List<Student> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtil.getConnection();
            String sql  = "insert into student(name,age) values(?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,student.getName());
            preparedStatement.setInt(2,student.getAge());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(resultSet,preparedStatement,connection);
        }



    }
}
