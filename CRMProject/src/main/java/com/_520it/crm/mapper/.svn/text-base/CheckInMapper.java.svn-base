package com._520it.crm.mapper;

import com._520it.crm.domain.CheckIn;
import com._520it.crm.query.CheckInQueryObject;
import com._520it.crm.query.QueryObject;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CheckInMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CheckIn record);

    CheckIn selectByPrimaryKey(Long id);

    List<CheckIn> selectAll();

    int updateByPrimaryKey(CheckIn record);
    
    List<CheckIn> queryByEid(Long id);
    

    Long queryByConditionCount(QueryObject qo);
    List<CheckIn> queryByCondition(QueryObject qo);


	Long queryCheckInByEidCount(Long id);
	
	List<CheckIn> queryCheckInByEid(Long id);
}