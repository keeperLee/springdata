package com.jerry.dao;

import com.jerry.domain.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

import javax.sql.DataSource;
import java.util.List;

public class StudentSpringJdbcImplTest {


    private ApplicationContext ctx = null;
    private StudentDAO studentDAO = null;


    @Before
    public void setUp(){
        ctx = new ClassPathXmlApplicationContext("beans.xml");
        studentDAO   = (StudentDAO) ctx.getBean("studentDAO");
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public  void testDataSource(){
        System.out.println("testDataSource");
        DataSource dataSource = (DataSource) ctx.getBean("dataSource");
        Assert.notNull(dataSource);

    }


    @Test
    public  void testJdbcTemplate(){
        System.out.println("testJdbcTemplate");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        Assert.notNull(jdbcTemplate);

    }


    @Test
    public void testQuery(){


        List<Student> students = studentDAO.query();

        for (Student student :students){
            System.out.println("id:"+student.getId()+",name:" +student.getName()+"age:"+student.getAge());
        }
    }

    @Test
    public void testSave(){

        Student student = new Student();
        student.setAge(20);
        student.setName("test-spring-jdbc");
        studentDAO.save(student);


    }

}
