package com._520it.crm.service.impl;

import com._520it.crm.domain.CustomerTransfer;
import com._520it.crm.mapper.CustomerTransferMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.ICustomerTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/21.
 */
@Service
public class CustomerTransferServiceImpl implements ICustomerTransferService {

    @Autowired
    private CustomerTransferMapper dao;

    @Override
    public int save(CustomerTransfer transfer) {
        return dao.insert(transfer);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public CustomerTransfer get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int update(CustomerTransfer transfer) {
        return dao.updateByPrimaryKey(transfer);
    }

    @Override
    public PageResult listAll() {
        return new PageResult(Long.parseLong(dao.selectAll().size() + ""), dao.selectAll());
    }

    @Override
    public PageResult queryByCondition(QueryObject qo) {
        // 根据查询条件查询出总条数
        Long count = dao.queryByConditonCount(qo);
        if (count == 0) { // 总条数为0,返回空的结果集
            return PageResult.EMPTY;
        } else {
            // 返回查询的结果集
            List<CustomerTransfer> listData = dao.queryByCondition(qo);
            return new PageResult(count, listData);
        }
    }
}
