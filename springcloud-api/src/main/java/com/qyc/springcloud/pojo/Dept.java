package com.qyc.springcloud.pojo;

import java.io.Serializable;

/**
 * @author qianyongchao
 * @date 2021-04-29-23:07
 */
//@Data
//@NoArgsConstructor
//@Accessors(chain = true) //链式写法
public class Dept implements Serializable { //Dept 实体类， orm 类表关系映射

    private Long deptNo;//主键

    private String dName;

    //这个数据存在哪个数据库的字段~微服务，一个服务对应一个数据库，同一个信息可能存在不同的数据库
    private String db_source;

    public Dept(Long deptNo, String dName, String db_source) {
        this.deptNo = deptNo;
        this.dName = dName;
        this.db_source = db_source;
    }

    public Long getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Long deptNo) {
        this.deptNo = deptNo;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getDb_source() {
        return db_source;
    }

    public void setDb_source(String db_source) {
        this.db_source = db_source;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", dName='" + dName + '\'' +
                ", db_source='" + db_source + '\'' +
                '}';
    }
}
