package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Setter
@Getter
@Alias("Department")
public class Department {
    private Long id;
    private String sn; // 编号
    private String name; // 部门名称
    private Employee manager; // 部门经理
    private Department parent; // 上级部门
    private Boolean state; // 状态：0为正常 -1：为停用
    private String text; // 树形部门菜单显示文本
    List<Department> children; // 子部门


    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", state=" + state +
                '}';
    }
}