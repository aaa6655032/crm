package com._520it.crm.service;

import com._520it.crm.domain.Employee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

import java.util.List;

/**
 * Created by Administrator on 2016/9/13.
 */

public interface IEmployeeService {

    int save(Employee e);

    int delete(Long id);

    Employee get(Long id);

    int update(Employee e);

    List<Employee> listAll();



    Employee queryByLogin(String username, String password);
    
    // 高级查询
     PageResult queryByCondition(QueryObject qo);

    List<Long> queryByRoleIdByEid(Long eid);

    PageResult selectMangerList();

    /*根据潜在客户查询负责人*/
    List<Employee> selectByPotential();
    /*根据正式客户查询负责人*/
    List<Employee> selectByCustomer();

    // 查询用户根据客户负责人的Id
    List<Employee> selectByInCharge();

    PageResult sellerList();
}
