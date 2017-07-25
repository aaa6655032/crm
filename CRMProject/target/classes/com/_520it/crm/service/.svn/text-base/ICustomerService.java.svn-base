package com._520it.crm.service;

import com._520it.crm.domain.Customer;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

import javax.servlet.ServletOutputStream;
import java.util.List;

/**
 * Created by Administrator on 2016/9/19.
 */
public interface ICustomerService {

    int save(Customer c);

    int delete(Long id);

    Customer get(Long id);

    int update(Customer c);

    PageResult listAll();


    // 高级查询
    PageResult queryByCondition(QueryObject qo);

    // 高级查询
    PageResult queryCustomerByCondition(QueryObject qo);

    // 高级查询
    PageResult queryResourcePoolByCondition(QueryObject qo);

    PageResult selectByinChargeId(Long userId);

    int updateByChargeId(Long id, Long inchargeId);

    //
    int updateStatusFalseById(Long id);

    // 潜在用户转正
    int updateStatusSuccessById(Long id);

    // 用户吸纳资源池客户
    int customerAdmit(Long inchargeId, Long id);

    // 正式客户移入资源池
    int moveToResourcePool(Long inchargeId, Long id);

    int lostCustomer(Long id, Long id1);

    PageResult selectForOrder();

    List<Customer> selectAll();

    int exportCustomer(ServletOutputStream outputStream);


}
