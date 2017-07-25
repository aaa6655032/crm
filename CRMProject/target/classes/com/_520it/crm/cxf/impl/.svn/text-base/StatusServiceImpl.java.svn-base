package com._520it.crm.cxf.impl;

import java.util.List;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com._520it.crm.cxf.IStatusService;
import com._520it.crm.domain.GuaranteeItem;
import com._520it.crm.service.IGuaranteeItemService;
@WebService//标明该接口是一个webService服务接口
@SOAPBinding(style=Style.RPC)//表示遵循远程过程调用协议
@Component
public class StatusServiceImpl implements IStatusService{
    @Autowired
	private  IGuaranteeItemService guaranteeItemService;
	//根据明细的状态查询出对应的明细集合
	public List<GuaranteeItem> queryStatusByItem(int status) {
		
		return guaranteeItemService.queryStatusByItem(status);
	}

}
