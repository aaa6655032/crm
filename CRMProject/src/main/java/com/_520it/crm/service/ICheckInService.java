package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.CheckIn;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CheckInQueryObject;
import com._520it.crm.query.QueryObject;

public interface ICheckInService {

	//往数据库中插入数据
	int save(CheckIn checkIn);
	
	//往数据库中更新数据
	int update(CheckIn checkIn);
	
	//从数据库中查询数据
	CheckIn get(Long id);
	
	
	//从数据库中查询出所有数据
	List<CheckIn> listAll();
	
	PageResult queryByCondition(QueryObject qo);
	
	//普通员工查询自己的签到记录
	PageResult queryCheckInByEid(Long id);
	
	//根据用户名从数据库中查询出对应数据

	int signIn(CheckIn checkIn, Long id);

	int signOut(CheckIn checkIn, Long id);

	int AddCheckIn(CheckIn checkIn, Long id);
	
	
	
}
