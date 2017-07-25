package com._520it.crm.service;

import com._520it.crm.domain.Department;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

import java.util.List;

/**
 * Created by Administrator on 2016/9/13.
 */

public interface IDepartmentService {
    int save(Department e);

    int delete(Long id);

    Department get(Long id);

    int update(Department e);

    List<Department> listAll();


     PageResult queryByCondition(QueryObject qo);

    List<Department> queryDepartmentMenu();

    List<Department> getByMid(Long id);
}
