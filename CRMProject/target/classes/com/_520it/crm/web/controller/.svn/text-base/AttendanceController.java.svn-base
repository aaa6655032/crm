package com._520it.crm.web.controller;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.Attendance;
import com._520it.crm.domain.Employee;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.AttendanceQueryObject;
import com._520it.crm.query.CheckInQueryObject;
import com._520it.crm.service.IAttendanceService;
import com._520it.crm.util.PermissionUtils;
import com._520it.crm.util.UserContext;

@Controller
public class AttendanceController  extends BaseController{

	@Autowired
	private IAttendanceService attendanceService;
	
	@RequestMapping("/attendance")
	public String index() {
		
		return "attendance";
	}
	
	@RequestMapping("/attendance_list")
	@ResponseBody
	public PageResult list(CheckInQueryObject qo,HttpServletRequest request) {
		PageResult result = null;
		String function = "com._520it.crm.web.controller.CheckInController:AddCheckIn";
		boolean checkPermission = PermissionUtils.checkPermission(function );
		
		System.out.println("*****************************************"+checkPermission);
		if (checkPermission) {
			result = attendanceService.queryByCondition(qo);
			return result;
		}
		Employee current = (Employee) request.getSession().getAttribute(
				UserContext.USER_IN_SESSION);
		Long id = current.getId();
		//System.out.println(id);
		result = attendanceService.queryAttendanceByEid(id);
		return result;
	}

	
	//更新考勤表
	@RequestMapping("/attendance_updateAttendance")
	@ResponseBody
	public AjaxResult updateAttendance() {
		  AjaxResult result = null;
	            int row = attendanceService.updateAttendance();
	            try {
	            if (row > 0) {
	                result = new AjaxResult(true, "导入考勤表成功");

	            } else {
	                result = new AjaxResult(false, "导入考勤表失败");

	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            result = new AjaxResult(false, "导入考勤表异常");
	        }
	        return result;

	}
	

	

	    @RequestMapping("/attendance_delete")
	    @ResponseBody
	    public AjaxResult delete(Long id) {
	        AjaxResult result = null;
	        try {

	            int row = attendanceService.delete(id);
	            if (row > 0) {
	                result = new AjaxResult(true, "删除成功");

	            } else {
	                result = new AjaxResult(false, "删除失败");

	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            result = new AjaxResult(false, "删除异常");
	        }
	        return result;

	    }

	    @RequestMapping("/attendance_save")
	    @ResponseBody
	    public AjaxResult save(Attendance attendance) {
	        AjaxResult result = null;
	        try {
	            int effectRows = attendanceService.save(attendance);
	            if (effectRows > 0) {
	                result = new AjaxResult(true, "保存成功");
	            } else {
	                result = new AjaxResult(false, "保存失败");
	            }
	        } catch (Exception e1) {
	            e1.printStackTrace();
	            result = new AjaxResult(false, "保存异常");
	        }
	        return result;
	    }

	    @RequestMapping("/attendance_update")
	    @ResponseBody
	    public AjaxResult update(Attendance attendance) {
	        AjaxResult result = null;
	        try {
	            int effectRows = attendanceService.update(attendance);
	            if (effectRows > 0) {
	                result = new AjaxResult(true, "更改成功");
	            } else {
	                result = new AjaxResult(false, "更改失败");
	            }
	        } catch (Exception e1) {
	            e1.printStackTrace();
	            result = new AjaxResult(false, "更改异常");
	        }
	        return result;
	    }
	    
	    //导出到表格
	    @RequestMapping("/attendance_export")
	    @ResponseBody
	    public AjaxResult exportAttendance(HttpServletResponse response) {
	    	AjaxResult result = null;
	    	try {
	    		response.setHeader("Content-Disposition", "attachment;filename=SignInTable.xls");
	            ServletOutputStream outputStream = response.getOutputStream();
	    		int effectRows = attendanceService.exportAttendance(outputStream);
	    		if (effectRows > 0) {
	    			result = new AjaxResult(true, "导出成功");
	    		} else {
	    			result = new AjaxResult(false, "导出失败 ! 请关闭该文件后重新导出 !");
	    		}
	    	} catch (Exception e1) {
	    		e1.printStackTrace();
	    		result = new AjaxResult(false, "导出异常");
	    	}
	    	return result;
	    }

	
	
	
	
}
