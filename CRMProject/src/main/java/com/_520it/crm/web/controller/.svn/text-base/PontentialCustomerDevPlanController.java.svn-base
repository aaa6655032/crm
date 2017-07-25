package com._520it.crm.web.controller;

import com._520it.crm.domain.CustomerDevPlan;
import com._520it.crm.domain.Employee;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CustomerDevPlanQueryObject;
import com._520it.crm.service.ICustomerDevPlanService;
import com._520it.crm.util.RequiredPermission;
import com._520it.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/20.
 */
@Controller
public class PontentialCustomerDevPlanController extends BaseController {


    @Autowired
    private ICustomerDevPlanService customerDevPlanService;
    @RequiredPermission("查看潜在客户开发计划")
    @RequestMapping("/potentialCustomerDevPlan")
    public String index() {
        System.out.println("IndexController.customerDevPlan");
        return "potentialCustomerDevPlan";
    }

    @RequestMapping("/potentialCustomerDevPlan_list")
    @ResponseBody
    public PageResult list(CustomerDevPlanQueryObject qo) {
        PageResult result = null;
        result = customerDevPlanService.queryPontentialDevPlanByCondition(qo);
        return result;
    }

    @RequestMapping("/potentialCustomerDevPlan_save")
    @ResponseBody
    public AjaxResult save(CustomerDevPlan plan) {
        Employee employee = (Employee) UserContext.getLocalRequest().getSession().getAttribute(UserContext.USER_IN_SESSION);
        plan.setInputuser(employee);
        plan.setInputtime(new Date());
        plan.setType(0);
        AjaxResult result = null;
        try {
            int effectCount = customerDevPlanService.save(plan);
            if (effectCount > 0) {
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

    @RequestMapping("/potentialCustomerDevPlan_update")
    @ResponseBody
    public AjaxResult update(CustomerDevPlan plan) {

        AjaxResult result = null;
        try {
            int effectCount = customerDevPlanService.update(plan);
            if (effectCount > 0) {
                result = new AjaxResult(true, "更新成功");
            } else {
                result = new AjaxResult(false, "更新失败");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            result = new AjaxResult(false, "更新异常");
        }
        return result;
    }

    @RequestMapping("/potentialCustomerDevPlan_delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            int effectCount = customerDevPlanService.delete(id);
            if (effectCount > 0) {
                result = new AjaxResult(true, "删除成功");
            } else {
                result = new AjaxResult(false, "删除失败");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            result = new AjaxResult(false, "删除异常");
        }
        return result;
    }

}
