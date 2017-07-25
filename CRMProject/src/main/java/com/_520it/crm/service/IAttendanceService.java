package com._520it.crm.service;

import com._520it.crm.domain.Attendance;
import com._520it.crm.domain.Employee;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.AttendanceQueryObject;
import com._520it.crm.query.QueryObject;

import java.util.List;

import javax.servlet.ServletOutputStream;



public interface IAttendanceService {

    int save(Attendance attendance);

    int delete(Long id);

    Attendance get(Long id);

    int update(Attendance attendance);

    List<Attendance> listAll();
    
    // 高级查询
     PageResult queryByCondition(QueryObject qo);

	int updateAttendance();

	PageResult queryAttendanceByEid(Long id);

	int exportAttendance(ServletOutputStream outputStream);



  
}
