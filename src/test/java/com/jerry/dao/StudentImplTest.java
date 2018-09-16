package com.jerry.dao;

import com.jerry.domain.Student;
import org.junit.Test;

import java.util.List;

public class StudentImplTest {

    @Test
    public void testQuery(){
        StudentDAO studentDAO = new StudentDAOImpl();

        List<Student> students = studentDAO.query();

        for (Student student :students){
            System.out.println("id:"+student.getId()+",name:" +student.getName()+"age:"+student.getAge());
        }
    }

    @Test
    public void testSave(){
        StudentDAO studentDAO = new StudentDAOImpl();
        Student student = new Student();
        student.setAge(10);
        student.setName("fd奋斗奋斗");
        studentDAO.save(student);


    }

}
