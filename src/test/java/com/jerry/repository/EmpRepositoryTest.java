package com.jerry.repository;

import com.jerry.domain.Emp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpRepositoryTest {

    private ApplicationContext ctx = null;
    private  EmpRepository empRepository = null;

    @Before
    public void setUp(){
        ctx = new ClassPathXmlApplicationContext("beans-new.xml");
        empRepository = ctx.getBean(EmpRepository.class);
        System.out.println("setup");
    }

    @After
    public void tearDown(){
        ctx = null;
        System.out.println("tearDown");
    }

    @Test
    public void testFindByName(){
        Emp emp = empRepository.findByName("ff");
        System.out.println("age:"+emp.getAge()+",id:" + emp.getId());

    }

}
