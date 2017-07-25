package com._520it.crm.web.controller;

import com._520it.crm.domain.Menu;
import com._520it.crm.service.IMenuService;
import com._520it.crm.util.RequiredPermission;
import com._520it.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
@Controller
public class MenuController extends BaseController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/menu")
    @ResponseBody
    public List<Menu> queryMenu(HttpSession session) {
        List<Menu> result = (List<Menu>) session.getAttribute(UserContext.MENU_IN_SESSION);
        return result;
    }

    @RequiredPermission("报表查询")
    public void chartList() {

    }

    @RequiredPermission("考勤查询")
    public void chenkInList() {

    }

    @RequiredPermission("订单合同管理查询")
    public void orderAndcontractList() {

    }

    @RequiredPermission("工资模块查询")
    public void salaryList() {

    }

    @RequiredPermission("今日计划查询")
    public void todayTaskList() {

    }

    @RequiredPermission("个人工具查询")
    public void ToolsList() {

    }

    @RequiredPermission("售后查询")
    public void guaranteeList() {

    }
}
