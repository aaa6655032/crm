package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.CheckIn;
import com._520it.crm.domain.Vacate;
import com._520it.crm.mapper.VacateMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;
import com._520it.crm.query.VacateQueryObject;
import com._520it.crm.service.IVacateService;

@Service
public class VacateServiceImpl implements IVacateService{

	@Autowired
	private VacateMapper dao;
	
	public int save(Vacate vacate) {
		return dao.insert(vacate);
	}

	public int delete(Long id) {
		Vacate vacate = dao.selectByPrimaryKey(id);
	
		if (vacate.getState() == Vacate.NORMAL) { //未审核
			dao.deleteByPrimaryKey(id);
			return  1 ;
		}
		return -1 ;
		
	}

	public int update(Vacate vacate) {
		System.out.println("222222222222222");
		System.out.println(vacate);
		System.out.println(vacate.getId());
		System.out.println("222222222222222");
		
		Vacate vac = dao.selectByPrimaryKey(vacate.getId());
		//判断是否处于审核状态
		if (vac.getState() == Vacate.NORMAL) { //未审核
			return dao.updateByPrimaryKey(vacate);
		}
		return 0 ;
	}

	public Vacate get(Long id) {
		return dao.selectByPrimaryKey(id);
	}

	public List<Vacate> listAll() {
		return dao.selectAll();
	}

	public PageResult queryByCondition(QueryObject qo) {
		// 根据查询条件查询出总条数
				Long count = dao.queryByConditionCount(qo);
				if (count == 0) { // 总条数为0,返回空的结果集
					return PageResult.EMPTY;
				} else {
					// 返回查询的结果集
					List<Vacate> listData = dao.queryByCondition(qo);
					return new PageResult(count, listData);
				}
	}

	public PageResult queryVacateByEid(QueryObject qo) {
		// 根据查询条件查询出总条数
		Long count = dao.queryVacateByEidCount(qo);
		if (count == 0) { // 总条数为0,返回空的结果集
			return PageResult.EMPTY;
		} else {
			// 返回查询的结果集
			List<Vacate> listData = dao.queryVacateByEid(qo);
			return new PageResult(count, listData);
		}
	}

	//请假单审核
	public int audit(Vacate vacate) {
		System.out.println(vacate);
		System.out.println(vacate.getId());
		Vacate v = dao.selectByPrimaryKey(vacate.getId());
		if (v.getState() == Vacate.AUDIT) { //未审核
			return 0;
		}
		System.out.println("3333333333");
		System.out.println(v);
		vacate.setBegintime(v.getBegintime());
		vacate.setEndtime(v.getEndtime());
		vacate.setEmployee(v.getEmployee());
		vacate.setState(Vacate.AUDIT);
		return  dao.updateByPrimaryKey(vacate);
	}

	

	

	
}
