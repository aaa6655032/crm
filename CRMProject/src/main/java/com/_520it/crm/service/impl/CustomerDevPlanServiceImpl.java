package com._520it.crm.service.impl;

import com._520it.crm.domain.CustomerDevPlan;
import com._520it.crm.mapper.CustomerDevPlanMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.ICustomerDevPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/20.
 */
@Service
public class CustomerDevPlanServiceImpl implements ICustomerDevPlanService {

    @Autowired
    private CustomerDevPlanMapper dao;

    @Override
    public int save(CustomerDevPlan plan) {
        return dao.insert(plan);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public CustomerDevPlan get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int update(CustomerDevPlan plan) {
        return dao.updateByPrimaryKey(plan);
    }

    @Override
    public PageResult listAll() {
        return new PageResult(Long.parseLong(dao.selectAll().size() + ""), dao.selectAll());
    }

    @Override
    public PageResult queryDevPlanByCondition(QueryObject qo) {
        // 根据查询条件查询出总条数
        Long count = dao.queryDevPlanByConditionCount(qo);
        if (count == 0) { // 总条数为0,返回空的结果集
            return PageResult.EMPTY;
        } else {
            // 返回查询的结果集
            List<CustomerDevPlan> listData = dao.queryDevPlanByCondition(qo);
            return new PageResult(count, listData);
        }
    }

    @Override
    public PageResult queryPontentialDevPlanByCondition(QueryObject qo) {
        // 根据查询条件查询出总条数
        Long count = dao.queryPotentialDevPlanByConditionCount(qo);
        if (count == 0) { // 总条数为0,返回空的结果集
            return PageResult.EMPTY;
        } else {
            // 返回查询的结果集
            List<CustomerDevPlan> listData = dao.queryPotentialDevPlanByCondition(qo);
            return new PageResult(count, listData);
        }
    }
}
