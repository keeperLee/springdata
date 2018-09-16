package com.jerry.repository;

import com.jerry.domain.Emp;
import org.springframework.data.repository.Repository;

public interface EmpRepository extends Repository <Emp,Integer>{
    public Emp findByName(String name);

}
