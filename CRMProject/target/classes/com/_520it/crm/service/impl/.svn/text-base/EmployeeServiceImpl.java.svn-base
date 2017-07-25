package com._520it.crm.service.impl;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Role;
import com._520it.crm.mapper.EmployeeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/15.
 */
@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private EmployeeMapper dao;

    @Override
    public int save(Employee e) {

        List<Role> roles = e.getRoles();
        // 员工有角色时,保存角色的
        if (roles != null) {
            for (Role role : roles) {
                dao.handleRelation(e.getId(), role.getId());
            }
        }
        return dao.insert(e);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public Employee get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int update(Employee e) {

        List<Role> roles = e.getRoles();
        // 员工有角色时,保存角色的
        if (roles != null) {
            // 删除原有的角色
            dao.deleteRoleByEid(e.getId());
            // 新增角色
            for (Role role : roles) {
                dao.handleRelation(e.getId(), role.getId());
            }
        }

        return dao.updateByPrimaryKey(e);
    }

    @Override
    public List<Employee> listAll() {
        return dao.selectAll();
    }

    @Override
    public Employee queryByLogin(String username, String password) {
        return dao.queryByLogin(username, password);
    }

    // 高级查询+分页
    public PageResult queryByCondition(QueryObject qo) {
        // 根据查询条件查询出总条数
        Long count = dao.queryByConditionCount(qo);
        if (count == 0) { // 总条数为0,返回空的结果集
            return PageResult.EMPTY;
        } else {
            // 返回查询的结果集
            List<Employee> listData = dao.queryByCondition(qo);
            return new PageResult(count, listData);
        }
    }

    /**
     * 根据员工的id,查询出对应的角色id数组
     *
     * @param eid 员工id
     * @return 返回对应角色数组
     */
    @Override
    public List<Long> queryByRoleIdByEid(Long eid) {
        return dao.queryByRoleIdByEid(eid);
    }

    @Override
    public PageResult selectMangerList() {

        Long total = dao.selectAllCount();
        List<Employee> results = dao.selectAll();

        return new PageResult(total, results);
    }


    @Override
    public List<Employee> selectByPotential() {
        return dao.selectByPotential();
    }

    @Override
    public List<Employee> selectByCustomer() {
        return dao.selectByCustomer();
    }

    @Override
    public List<Employee> selectByInCharge() {
        return dao.selectByInCharge();
    }

    public PageResult sellerList() {
        Long total = dao.selectAllCount();
        List<Employee> results = dao.selectAll();
        return new PageResult(total, results);
    }
}


