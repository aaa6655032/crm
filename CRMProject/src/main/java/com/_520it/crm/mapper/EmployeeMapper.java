package com._520it.crm.mapper;

import com._520it.crm.domain.Employee;
import com._520it.crm.query.QueryObject;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employee record);

    Employee selectByPrimaryKey(Long id);

    List<Employee> selectAll();

    int updateByPrimaryKey(Employee record);

    Employee queryByLogin(@Param("username") String username, @Param("password") String password);

    List<Employee> queryByCondition(QueryObject qo);

    Long queryByConditionCount(QueryObject qo);

    List<Long> queryByRoleIdByEid(Long eid);

    int handleRelation(@Param("Eid") Long Eid, @Param("Rid") Long Rid);

    int deleteRoleByEid(Long eid);

    // 查询所有员工的总条数
    Long selectAllCount();

    /*根据潜在客户查询负责人*/
    List<Employee> selectByPotential();

    /*根据正式客户查询负责人*/
    List<Employee> selectByCustomer();

    List<Employee> selectByInCharge();


}