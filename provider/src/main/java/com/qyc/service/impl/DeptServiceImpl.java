package com.qyc.service.impl;

import com.qyc.dao.DeptDao;
import com.qyc.service.DeptService;
import com.qyc.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptDao deptDao;

    public boolean addDept(Dept dept) {
        return deptDao.addDept(dept);
    }
    public Dept queryById(Long id) {
        //return deptDao.queryById(id);
        return null;
    }
    public List<Dept> queryAll() {
        return deptDao.queryAll();
    }
}
