package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.GuaranteeItem;

public interface IGuaranteeItemService {
        //删除
	    int delete(Long id);
        //保存
	    int save(GuaranteeItem record);
        //查询单条数据
	    GuaranteeItem selectByPrimaryKey(Long id);
        //查询全部
	    List<GuaranteeItem> selectAll();
        //修改
	    int update(GuaranteeItem record);
	    //根据保修单查询对应的明细
		List<GuaranteeItem> selectAllItem(Long id);
		//根据保修单id查询对应的明细总数
		Long selectItems(Long id);
		//根据明细的状态查询出对应的明细集合
		List<GuaranteeItem> queryStatusByItem(int status);
}
