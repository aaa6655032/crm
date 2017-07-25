package com._520it.crm.service;

import com._520it.crm.domain.Role;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

import java.util.List;

/**
 * Created by Administrator on 2016/9/13.
 */

public interface IRoleService {

    int save(Role r);
    int delete(Long id);
    Role get(Long id);
    int update(Role r);
    List<Role> listAll();
    PageResult queryByCondition(QueryObject qo);
    PageResult queryByRid(Long rid);
    List<Role> selectByEid(Long id);
}
