package com.sq.controller;

import com.sq.mapper.DepartmentMapper;
import com.sq.mapper.EmployeeMapper;
import com.sq.pojo.Department;
import com.sq.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author sq ♥ovo♥
 * @date 2023/9/15 - 15:02
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    DepartmentMapper departmentMapper;

    // 获取所有员工信息
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeMapper.getEmployees();

        System.out.println(employees);
        model.addAttribute("emps",employees);

        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddpage(Model model){

        //查出所有部门的信息
        Collection<Department> departments = departmentMapper.getDepartments();
        System.out.println(departments);
        model.addAttribute("departments",departments);

        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee,Model model){

        //添加的操作
        System.out.println(employee);
        employeeMapper.save(employee); //调用底层业务方法，保存员工信息

        return "redirect:/emps";
    }

    //去修改页面
    /*链接a标签形式用getmapping*/
    @GetMapping("/emp/{id}")
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model){

        //查出原来的数据
        Employee employee = employeeMapper.get(id);
        System.out.println(employee);
        model.addAttribute("emp",employee);

        //查出所有部门的信息
        Collection<Department> departments = departmentMapper.getDepartments();
        model.addAttribute("departments",departments);

        return "emp/update";
    }

    //稍等，给mapper增加一个修改方法
    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeMapper.update(employee);
        return "redirect:/emps";
    }


    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable("id")Integer id){
        employeeMapper.delete(id);

        return "redirect:/emps";
    }
}