package com._520it.crm.service.impl;

import com._520it.crm.domain.Contract;
import com._520it.crm.mapper.ContractMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ShikieikiSama丶 on 2016/9/20.
 */


@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private ContractMapper dao;

    public int deleteByPrimaryKey(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    public int insert(Contract record) {
        return dao.insert(record);
    }

    public Contract selectByPrimaryKey(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    public List<Contract> selectAll() {
        return dao.selectAll();
    }

    public int updateByPrimaryKey(Contract record) {
        return dao.updateByPrimaryKey(record);
    }

    public PageResult queryByCondition(QueryObject qo) {
        Long count = dao.queryByConditionCount(qo);
        if(count > 0){
            List<Contract> rows = dao.queryByCondition(qo);
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
}
