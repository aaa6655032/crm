package com._520it.crm.service.impl;

import com._520it.crm.domain.Permission;
import com._520it.crm.domain.Role;
import com._520it.crm.mapper.RoleMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/15.
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private RoleMapper dao;

    @Override
    public int save(Role role) {
        int effectCount = dao.insert(role);
        // 保存role和permission的Id到role_permission中间表,建立role和permission之间的关系
        for (Permission p : role.getPermissions()) {
            dao.handlerRelation(role.getId(), p.getId());
        }
        return effectCount;
     }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public Role get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int update(Role role) {
        // 删除原来的权限
        dao.deletePermissionByRid(role.getId());
        // 重新新增权限
        for (Permission permission : role.getPermissions()) {
            dao.handlerRelation(role.getId(), permission.getId());
        }
        return dao.updateByPrimaryKey(role);
    }

    @Override
    public List<Role> listAll() {
        return dao.selectAll();
    }


    // 高级查询+分页
    public PageResult queryByCondition(QueryObject qo) {
        // 根据查询条件查询出总条数
        Long count = dao.queryByConditionCount(qo);
        if (count == 0) { // 总条数为0,返回空的结果集
            return PageResult.EMPTY;
        } else {
            // 返回查询的结果集
            List<Role> listData = dao.queryByCondition(qo);
            return new PageResult(count, listData);
        }
    }

    // 根据角色的id,查找相对应的权限
    @Override
    public PageResult queryByRid(Long rid) {

        return new PageResult(Long.parseLong(dao.queryByRid(rid).size() + ""), dao.queryByRid(rid));
    }

    @Override
    public List<Role> selectByEid(Long id) {
        return dao.selectByEid(id);
    }

}


