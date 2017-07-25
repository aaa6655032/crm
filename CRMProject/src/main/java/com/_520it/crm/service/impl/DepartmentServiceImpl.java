package com._520it.crm.service.impl;

import com._520it.crm.domain.Department;
import com._520it.crm.mapper.DepartmentMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/13.
 */
@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private DepartmentMapper dao;

    @Override
    public int save(Department dept) {
        return dao.insert(dept);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public Department get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int update(Department dept) {
        return dao.updateByPrimaryKey(dept);
    }

    @Override
    public List<Department> listAll() {
        return dao.selectAll();
    }


    public PageResult queryByCondition(QueryObject qo) {
        // 根据查询条件查询出总条数
        Long count = dao.queryByConditonCount(qo);
        if (count == 0) { // 总条数为0,返回空的结果集
            return PageResult.EMPTY;
        } else {
            // 返回查询的结果集
            List<Department> listData = dao.queryByCondition(qo);
            return new PageResult(count, listData);
        }
    }

    @Override
    public List<Department> queryDepartmentMenu() {
        return dao.selectRoot();
    }

    @Override
    public List<Department> getByMid(Long id) {
        return dao.getByMid();
    }

}
