package com._520it.crm.mapper;

import com._520it.crm.domain.CustomerTransfer;
import com._520it.crm.domain.Department;
import com._520it.crm.query.QueryObject;

import java.util.List;

public interface CustomerTransferMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CustomerTransfer record);

    CustomerTransfer selectByPrimaryKey(Long id);

    List<CustomerTransfer> selectAll();

    int updateByPrimaryKey(CustomerTransfer record);

    Long queryByConditonCount(QueryObject qo);

    List<CustomerTransfer> queryByCondition(QueryObject qo);
}