package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Alias("Role")
public class Role {
    private Long id;
    private String sn; // 角色编号
    private String name; // 角色名称

    private List<Permission> permissions = new ArrayList<>();
}