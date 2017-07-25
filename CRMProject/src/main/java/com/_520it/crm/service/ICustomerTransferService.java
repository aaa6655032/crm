package com._520it.crm.service;

import com._520it.crm.domain.CustomerTransfer;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

/**
 * Created by Administrator on 2016/9/21.
 */
public interface ICustomerTransferService {
    int save(CustomerTransfer e);

    int delete(Long id);

    CustomerTransfer get(Long id);

    int update(CustomerTransfer e);

    PageResult listAll();

    // 高级查询
    PageResult queryByCondition(QueryObject qo);
}
