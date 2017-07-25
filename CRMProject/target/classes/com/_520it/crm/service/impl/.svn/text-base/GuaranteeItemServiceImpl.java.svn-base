package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.GuaranteeItem;
import com._520it.crm.mapper.GuaranteeItemMapper;
import com._520it.crm.service.IGuaranteeItemService;
@Service
public class GuaranteeItemServiceImpl implements IGuaranteeItemService{
    @Autowired
	private GuaranteeItemMapper dao;
	//删除
	public int delete(Long id) {
		
		return dao.deleteByPrimaryKey(id);
	}

	//保存
	public int save(GuaranteeItem record) {
		
		return dao.insert(record);
	}

	//查询单条数据
	public GuaranteeItem selectByPrimaryKey(Long id) {
		
		return dao.selectByPrimaryKey(id);
	}

	//查询全部
	public List<GuaranteeItem> selectAll() {
		
		return dao.selectAll();
	}

	//修改
	public int update(GuaranteeItem record) {
		
		return dao.updateByPrimaryKey(record);
	}

	//根据保修单查询对应的明细
	public List<GuaranteeItem> selectAllItem(Long id) {
		
		return dao.selectAllItem(id);
	}

	//根据保修单id查询对应的明细总数
	public Long selectItems(Long id) {
		
		return dao.selectItems(id);
	}

	//根据明细的状态查询出对应的明细集合
	public List<GuaranteeItem> queryStatusByItem(int status) {
		
		return dao.queryStatusByItem(status);
	}

}
