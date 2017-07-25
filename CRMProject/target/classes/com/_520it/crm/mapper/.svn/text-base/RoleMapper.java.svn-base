package com._520it.crm.mapper;

import com._520it.crm.domain.Permission;
import com._520it.crm.domain.Role;
import com._520it.crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    Role selectByPrimaryKey(Long id);

    List<Role> selectAll();

    int updateByPrimaryKey(Role record);

    List<Role> queryByCondition(QueryObject qo);

    Long queryByConditionCount(QueryObject qo);

    int handlerRelation(@Param("RId") Long RId, @Param("PId") Long PId);


    List<Permission> queryByRid(Long rid);

    int deletePermissionByRid(Long rid);

    List<Role> selectByEid(Long id);

}