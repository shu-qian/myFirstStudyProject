package com.sq.mapper;

import com.sq.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sq ♥ovo♥
 * @date 2023/9/15 - 14:58
 */
@Mapper
@Repository
public interface DepartmentMapper {
    // 获取所有部门信息
    List<Department> getDepartments();

    // 通过id获得部门
    Department getDepartment(Integer id);
}
