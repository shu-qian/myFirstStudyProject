package com.sq.mapper;

import com.sq.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sq ♥ovo♥
 * @date 2023/9/15 - 14:58
 */
@Mapper
@Repository
public interface EmployeeMapper {
    // 获取所有员工信息
    List<Employee> getEmployees();

    // 新增一个员工
    int save(Employee employee);

    // 通过id获得员工信息
    Employee get(Integer id);

    // 通过id删除员工
    int delete(Integer id);

    int update(Employee employee);
}
