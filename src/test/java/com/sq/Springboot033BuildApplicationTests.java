package com.sq;

import com.alibaba.druid.pool.DruidDataSource;
import com.sq.mapper.DepartmentMapper;
import com.sq.mapper.EmployeeMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class Springboot033BuildApplicationTests {
//    @Autowired
//    DataSource dataSource;
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;

    @Test
    void contextLoads() throws SQLException {
  /*      //看一下默认数据源
        System.out.println(dataSource.getClass());
        //看一下连接
        System.out.println(dataSource.getConnection());

        DruidDataSource druidDataSource = (DruidDataSource) this.dataSource;

        System.out.println("druidDataSource 数据源最大连接数：" +druidDataSource.getMaxActive());
        System.out.println("druidDataSource 数据源初始化连接数：" +druidDataSource.getInitialSize());
*/
        /*System.out.println(departmentMapper.getDepartments());
        System.out.println(departmentMapper.getDepartment(106));
*/
        System.out.println(employeeMapper.getEmployees());
        System.out.println(employeeMapper.get(1001));
    }

}
