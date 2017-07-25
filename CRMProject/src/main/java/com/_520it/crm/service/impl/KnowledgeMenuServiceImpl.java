package com._520it.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com._520it.crm.domain.KnowledgeMenu;
import com._520it.crm.mapper.KnowledgeMenuMapper;
import com._520it.crm.service.IKnowledgeMenuService;
@Service
public class KnowledgeMenuServiceImpl implements IKnowledgeMenuService{
     @Autowired
	 private KnowledgeMenuMapper dao;
	public List<KnowledgeMenu> queryKnowledgeMenu() {
	
		return dao.selectRoot();
	}

}
