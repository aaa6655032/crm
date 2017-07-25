package com._520it.crm.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com._520it.crm.domain.Salary;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.QueryObject;

public interface ISalaryService {

	
    int save(Salary salary);

    int delete(Long id);

    Salary get(Long id);

    int update(Salary salary);

    List<Salary> listAll();
    
    // 高级查询
     PageResult queryByCondition(QueryObject qo);

     PageResult querySalaryByEid(Long id );


	void uploadSalary(MultipartFile file);

	

	
	
}
