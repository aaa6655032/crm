package com._520it.crm.service;

import com._520it.crm.domain.OrderBill;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

import java.util.List;

/**
 * Created by ShikieikiSama丶 on 2016/9/20.
 */
public interface IOrderBillService {
    int deleteByPrimaryKey(Long id);

    int insert(OrderBill record);

    OrderBill selectByPrimaryKey(Long id);

    List<OrderBill> selectAll();

    int updateByPrimaryKey(OrderBill record);

    // 高级查询
    PageResult queryByCondition(QueryObject qo);

    int checked(Long id);

    int noChecked(Long id);

    void updateStatus(Long id);
}
