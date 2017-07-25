package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.CheckIn;
import com._520it.crm.domain.Vacate;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CheckInQueryObject;
import com._520it.crm.query.QueryObject;
import com._520it.crm.query.VacateQueryObject;

public interface IVacateService {

	//往数据库中插入数据
	int save(Vacate vacate);
	
	//往数据库中更新数据
	int update(Vacate vacate);
	
	//从数据库中查询数据
	Vacate get(Long id);
	
	
	//从数据库中查询出所有数据
	List<Vacate> listAll();
	
	
	
	PageResult queryByCondition(QueryObject qo);
	
	
	//普通员工查询自己的请假记录
	PageResult queryVacateByEid(QueryObject qo);

	int delete(Long id);

	int audit(Vacate vacate);
	
	
	
}
