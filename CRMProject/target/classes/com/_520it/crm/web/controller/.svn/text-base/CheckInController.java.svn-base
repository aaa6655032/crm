package com._520it.crm.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.CheckIn;
import com._520it.crm.domain.Employee;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CheckInQueryObject;
import com._520it.crm.service.ICheckInService;
import com._520it.crm.util.PermissionUtils;
import com._520it.crm.util.RequiredPermission;
import com._520it.crm.util.UserContext;

@Controller
public class CheckInController extends BaseController {

	@Autowired
	private ICheckInService checkInService;

	@RequestMapping("/checkIn")
	public String index() {
		return "checkIn";
	}

	@RequestMapping("/checkIn_list")
	@ResponseBody
	public PageResult list(CheckInQueryObject qo,HttpServletRequest request) {
		PageResult result = null;
		String function = "com._520it.crm.web.controller.CheckInController:AddCheckIn";
		boolean checkPermission = PermissionUtils.checkPermission(function );
		
		System.out.println("*****************************************"+checkPermission);
		if (checkPermission) {
			result = checkInService.queryByCondition(qo);
			return result;
		}
		Employee current = (Employee) request.getSession().getAttribute(
				UserContext.USER_IN_SESSION);
		Long id = current.getId();
		//System.out.println(id);
		result = checkInService.queryCheckInByEid(id);
		return result;
	}

	// 签到
	@RequestMapping("/checkIn_signIn")
	@ResponseBody
	public AjaxResult signIn(CheckIn checkIn, HttpServletRequest request) {
		Employee current = (Employee) request.getSession().getAttribute(
				UserContext.USER_IN_SESSION);
		Long id = current.getId();
		HttpServletRequest localRequest = UserContext.getLocalRequest();
		AjaxResult result = null;
		try {
			checkIn.setEmployee(current);
			checkIn.setUserip(localRequest.getRemoteAddr()); // 获取当前ip地址
			checkIn.setState(CheckIn.SIGNSTATE_NORMAL);
			int effectRows = checkInService.signIn(checkIn, id);
			if (effectRows > 0) {
				result = new AjaxResult(true, "签到成功");
			} else {
				result = new AjaxResult(false, "已签到或者已经签退!已签退请联系管理员补签!");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			result = new AjaxResult(false, "已经签退了,请联系管理员补签!");
		}
		return result;
	}

	// 签退
	@RequestMapping("/checkIn_signOut")
	@ResponseBody
	public AjaxResult signOut(CheckIn checkIn, HttpServletRequest request) {
		Employee current = (Employee) request.getSession().getAttribute(
				UserContext.USER_IN_SESSION);
		Long id = current.getId();
		// 设置请求到当前的线程中
		// UserContext.setLocalThread(request);
		HttpServletRequest localRequest = UserContext.getLocalRequest();
		AjaxResult result = null;
		try {
			checkIn.setEmployee(current);
			checkIn.setUserip(localRequest.getRemoteAddr()); // 获取当前ip地址
			checkIn.setState(CheckIn.SIGNSTATE_NORMAL);
			int effectRows = checkInService.signOut(checkIn, id);
			if (effectRows > 0) {
				result = new AjaxResult(true, "签退成功");
			} else {
				result = new AjaxResult(false, "签退失败!!");
			}
		} catch (Exception e1) {
			e1.printStackTrace();
			result = new AjaxResult(false, "签退异常,联系管理员!");
		}
		return result;
	}
	
	
	
	//    补签
	@RequiredPermission("考勤补签")
	@RequestMapping("/checkIn_checkIn")
	@ResponseBody
	public AjaxResult AddCheckIn(CheckIn checkIn, HttpServletRequest request) {
		System.err.println("111111111111111111111111111111");
		System.err.println("111111111111111111111111111111");
		System.err.println("111111111111111111111111111111");
		System.err.println("111111111111111111111111111111");
		System.err.println("111111111111111111111111111111");
		System.out.println(checkIn.getEmployee().getId());
		Date date = new Date();  ///设置补签时间
		AjaxResult result = null;
		Employee current = (Employee) request.getSession().getAttribute(
				UserContext.USER_IN_SESSION);
		Long currentid = current.getId();   //获取当当前登陆用户的id 
		HttpServletRequest localRequest = UserContext.getLocalRequest();
		try {
			int effectRows = -1 ;
			checkIn.setUserip(localRequest.getRemoteAddr()); // 获取当前ip地址
			checkIn.setCheckman(current);  //设置补签人
			checkIn.setChecktime(date); //设置补签时间
			Long id = checkIn.getId();  //获取当前的记录的ID
			if (id != null) { //修改补签
				 effectRows = checkInService.update(checkIn);
			}else{//新增一条补签
				 effectRows = checkInService.save(checkIn);
			}
			if (effectRows > 0) {
				result = new AjaxResult(true, "补签成功");
			} else {
				result = new AjaxResult(false, "补签失败!!");
			}
		
		} catch (Exception e1) {
			e1.printStackTrace();
			result = new AjaxResult(false, "补签异常,请重新补签!");
		}
		return result;
	}
	
	
	 //新增补签时间
	 @RequestMapping("/checkIn_save")
	    @ResponseBody
	    public AjaxResult save(CheckIn checkIn, HttpServletRequest request) {
	        AjaxResult result = null;
	        try {
	            int effectRows = checkInService.save(checkIn);
	            if (effectRows > 0) {
	                result = new AjaxResult(true, "新增补签成功");
	            } else {
	                result = new AjaxResult(false, "新增补签失败");
	            }
	        } catch (Exception e1) {
	            e1.printStackTrace();
	            result = new AjaxResult(false, "新增补签失败,请重新补签");
	        }
	        return result;
	    }

	 
	 
	 
	 //补签修改
	    @RequestMapping("/checkIn_update")
	    @ResponseBody
	    public AjaxResult update(CheckIn checkIn, HttpServletRequest request) {
	        AjaxResult result = null;
	        try {
	        Employee current = (Employee) request.getSession().getAttribute(
					UserContext.USER_IN_SESSION);
			Long id = current.getId(); 
			checkIn.setCheckman(current);
			checkIn.setChecktime(new Date());
	            int effectRows = checkInService.update(checkIn);
	            if (effectRows > 0) {
	                result = new AjaxResult(true, "补签修改成功");
	            } else {
	                result = new AjaxResult(false, "补签修改失败");
	            }
	        } catch (Exception e1) {
	            e1.printStackTrace();
	            result = new AjaxResult(false, "补签修改失败,请重新补签");
	        }
	        return result;
	    }
	
	
	
	
	

}
