package com._520it.crm.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.Customer;
import com._520it.crm.domain.Guarantee;
import com._520it.crm.mapper.GuaranteeMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.service.IGuaranteeService;
@Service
public class GuaranteeServiceImpl implements IGuaranteeService{
    @Autowired
	private GuaranteeMapper dao;
	//删除
	public int delete(Long id) {
		//删除保修但是把对应的明细也删掉
		int effectCount = dao.deleteByPrimaryKey(id);
		 dao.deleteByItems(id);
		return effectCount;
	}

    //保存
	public int save(Guarantee record) {
		
		return dao.insert(record);
	}

	//查询单条
	public Guarantee selectByPrimaryKey(Long id) {
		
		return dao.selectByPrimaryKey(id);
	}

	//查询全部
	public List<Guarantee> selectAll() {
		
		return dao.selectAll();
	}

	//修改
	public int update(Guarantee record) {
	  
		return dao.updateByPrimaryKey(record);
	}

	//高级查询加分页
	public PageResult queryByCondition(QueryObject qo) {
		Long count = dao.selectByConditionCount(qo);
		if(count > 0 ){
			List<Guarantee> result = dao.selectByCondition(qo);
			return new PageResult(count,result);
		}else{
			return PageResult.EMPTY;
		}
		
	}

	//修改延保时间
	public int updateTime(Long id) {
		Guarantee guarantee = dao.selectByPrimaryKey(id);
		System.out.println(guarantee+"====================================");
		Calendar c = Calendar.getInstance();
	    c.setTime(guarantee.getDuetime());
		c.add(Calendar.YEAR,1);
		Date date = c.getTime();
		guarantee.setDuetime(date);
		int effectCount = dao.updateByPrimaryKey(guarantee);
		System.out.println(effectCount+"==============================================");
		return effectCount;
		
	}
}
