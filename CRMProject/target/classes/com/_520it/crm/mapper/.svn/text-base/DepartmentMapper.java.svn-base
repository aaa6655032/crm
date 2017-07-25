package com._520it.crm.mapper;

import com._520it.crm.domain.Department;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Department record);

    Department selectByPrimaryKey(Long id);

    List<Department> selectAll();

    int updateByPrimaryKey(Department record);

    Long queryByConditonCount(QueryObject qo);

    List<Department> queryByCondition(QueryObject qo);
    // 查询出父部门
    List<Department> selectRoot();

    // 根据父部门Id查询出子部门Id
    List<Department> selectByPid();

    List<Department> getByMid();
}