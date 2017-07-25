package com._520it.crm.mapper;

import com._520it.crm.domain.Vacate;
import com._520it.crm.query.QueryObject;
import com._520it.crm.query.VacateQueryObject;

import java.util.List;


import org.apache.ibatis.annotations.Param;

public interface VacateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Vacate record);

    Vacate selectByPrimaryKey(Long id);

    List<Vacate> selectAll();

    int updateByPrimaryKey(Vacate record);

    //全部
	Long queryByConditionCount(QueryObject qo);
	List<Vacate> queryByCondition(QueryObject qo);

	//个人
	Long queryVacateByEidCount(QueryObject qo);
	
	List<Vacate> queryVacateByEid(QueryObject qo);
	
	
}