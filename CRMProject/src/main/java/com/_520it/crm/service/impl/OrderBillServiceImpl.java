package com._520it.crm.service.impl;

import com._520it.crm.domain.OrderBill;
import com._520it.crm.mapper.OrderBillMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IOrderBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ShikieikiSama丶 on 2016/9/20.
 */


@Service
public class OrderBillServiceImpl implements IOrderBillService {

    @Autowired
    private OrderBillMapper dao;

    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int insert(OrderBill record) {
        return dao.insert(record);
    }

    public OrderBill selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    public List<OrderBill> selectAll() {
        return dao.selectAll();
    }

    public int updateByPrimaryKey(OrderBill record) {
        return dao.updateByPrimaryKey(record);
    }

    public PageResult queryByCondition(QueryObject qo) {
        Long count = dao.queryByConditionCount(qo);
        if(count > 0){
            List<OrderBill> rows = dao.queryByCondition(qo);
            return new PageResult(count,rows);
        }else{
            return PageResult.EMPTY;
        }
    }

    public int checked(Long id) {
        return dao.checked(id);
    }

    public int noChecked(Long id) {
        return dao.noChecked(id);
    }

    public void updateStatus(Long id) {
        dao.updateStatus(id);
    }
}
