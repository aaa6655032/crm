package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Customer;
import com._520it.crm.domain.Guarantee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface IGuaranteeService {
   
	//删除
    int delete(Long id);
    //保存
    int save(Guarantee record);
    //查询单条
    Guarantee selectByPrimaryKey(Long id);
    //查询全部
    List<Guarantee> selectAll();
    //修改
    int update(Guarantee record);
    
    //高级查询加分页
    PageResult queryByCondition(QueryObject qo);
    //修改延保时间
    int updateTime(Long id);
    
}
