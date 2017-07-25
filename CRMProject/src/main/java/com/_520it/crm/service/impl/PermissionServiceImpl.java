package com._520it.crm.service.impl;

import com._520it.crm.domain.Permission;
import com._520it.crm.mapper.PermissionMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IPermissionService;
import com._520it.crm.util.PermissionUtils;
import com._520it.crm.util.RequiredPermission;
import com._520it.crm.web.controller.BaseController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by Administrator on 2016/9/15.
 */

@Service
public class PermissionServiceImpl implements IPermissionService, ApplicationContextAware {

    @Autowired
    private PermissionMapper dao;

    private ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext ctx)
            throws BeansException {
        this.ctx = ctx;
    }

    @Override
    public PageResult queryByCondition(QueryObject qo) {
        Long count = dao.queryByConditionCount(qo);
        if ( count != null && count > 0 ) {
            List<Permission> results = dao.queryByCondition(qo);
            return new PageResult(count, results);
        } else {

            return PageResult.EMPTY;
        }

    }

    @Override
    public Permission queryByResource(String function) {
        return dao.queryByResource(function);
    }

    @Override
    public List<Permission> queryPermissionByEid(Long eid) {
        return dao.queryPermissionByEid(eid);
    }


    public void reload() {
        // 查询数据库中所有的权限表达式
        Set<String> resources = new HashSet<String>();
        List<Permission> ps = dao.selectAll();
        for (Permission permission : ps) {
            resources.add(permission.getResource());
        }
        // 扫描每个BaseController
        Map<String, BaseController> beansMap = ctx
                .getBeansOfType(BaseController.class);
        Collection<BaseController> controllers = beansMap.values();
        for (BaseController controller : controllers) {
            Method[] ms = controller.getClass().getDeclaredMethods();
            for (Method m : ms) {
                RequiredPermission rp = m
                        .getAnnotation(RequiredPermission.class);
                // 获取方法上对应的权限表达式
                String exp = PermissionUtils.buildResource(m);
                if (!resources.contains(exp)) {
                    if (rp != null) {
                        String name = rp.value();
                        Permission p = new Permission();
                        p.setName(name);
                        p.setResource(exp);
                        dao.insert(p);
                    }
                }
            }
        }
    }


}
