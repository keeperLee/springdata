package com.jerry.dao;

import com.jerry.domain.Student;

import java.util.List;

public interface StudentDAO {

    /*
    查询所有的学生
     */
    public List<Student> query();



    public void save(Student student);
}
