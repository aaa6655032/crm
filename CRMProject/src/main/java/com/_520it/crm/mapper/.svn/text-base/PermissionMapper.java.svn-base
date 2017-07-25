package com._520it.crm.mapper;

import com._520it.crm.domain.Permission;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface PermissionMapper {

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    Permission selectByPrimaryKey(Long id);

    List<Permission> selectAll();

    int updateByPrimaryKey(Permission record);

    // 高级查询总条数
    Long queryByConditionCount(QueryObject qo);
    // 高级查询+分页
    List<Permission> queryByCondition(QueryObject qo);

    Permission queryByResource(String function);

    List<Permission> queryPermissionByEid(Long eid);
    
}