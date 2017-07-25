package com._520it.crm.domain;

import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.List;

// 菜单
@Setter
@Getter
@Alias("Menu")
public class Menu {
    private Long id; // 节点id
    private String text; // 节点文本
    private String state; //节点状态
    private Boolean checked; //是否被选中。
    private String attributes; // 自定义属性
    private List<Menu> children; // 子菜单
    private String resource; // 权限控制
    private String iconCls; // 图标

}