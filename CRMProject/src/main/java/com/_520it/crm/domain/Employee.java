package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@Alias("Employee")
public class Employee {
    private Long id;
    private String username; // 账号
    private String realname; // 用户名
    private String password; // 密码
    private String tel; // 联系电话
    private String email; // 邮箱
    private Department dept; //部门
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date inputtime; // 录入时间
    private Boolean state; // 状态： 0 正常 ，-1离职
    private Boolean admin; // 是否为超级管理员

    private List<Role> roles; // 员工对应的角色

    @Override
    public String toString() {
		//
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", inputtime=" + inputtime +
                ", state=" + state +
                ", admin=" + admin +
                '}';
    }
}