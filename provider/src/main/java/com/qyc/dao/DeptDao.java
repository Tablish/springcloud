package com.qyc.dao;

import com.qyc.springcloud.pojo.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);

    //public Dept queryById(Long id);

    public List<Dept> queryAll();
}
