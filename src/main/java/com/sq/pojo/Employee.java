package com.sq.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author sq ♥ovo♥
 * @date 2023/9/8 - 17:45
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String email;
    private Integer gender;    //1 male, 0 female
    private Integer department;
    private Date birth;

    private Department theDepartment; // 冗余设计
}
