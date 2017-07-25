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
public class FastCheckInController extends BaseController {

	@Autowired
	private ICheckInService checkInService;

	@RequestMapping("/fastCheckIn")
	public String index() {
		return "fastCheckIn";
	}

}
