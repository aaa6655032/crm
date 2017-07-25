package com._520it.crm.service;

import java.util.List;

import com._520it.crm.domain.Know;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.KnowQueryObject;

public interface IKnowService {
	 int delete(Long id);
	    int save(Know record);
	    Know selectByPrimaryKey(Long id);
	    List<Know> selectAll();
	    int update(Know record);
	    void indexWriterReload();
	    PageResult query(KnowQueryObject qo);
	    PageResult querySearch(KnowQueryObject qo);
		Know queryContextById(Long id);
}
