package com._520it.crm.service;

import com._520it.crm.domain.Contract;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

import java.util.List;

/**
 * Created by ShikieikiSama丶 on 2016/9/20.
 */
public interface IContractService {
    int deleteByPrimaryKey(Long id);

    int insert(Contract record);

    Contract selectByPrimaryKey(Long id);

    List<Contract> selectAll();

    int updateByPrimaryKey(Contract record);

    // 高级查询
    PageResult queryByCondition(QueryObject qo);

    int checked(Long id);

    int noChecked(Long id);
}
