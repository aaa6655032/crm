package com._520it.crm.web.controller;

import com._520it.crm.domain.Customer;
import com._520it.crm.domain.Employee;
import com._520it.crm.domain.SystemDictionaryItem;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CustomerResourcePoolQueryObject;
import com._520it.crm.service.ICustomerService;
import com._520it.crm.service.IRoleService;
import com._520it.crm.service.ISystemDictionaryItemService;
import com._520it.crm.util.RequiredPermission;
import com._520it.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/19.
 */
@Controller
public class CustomerResourcePoolController extends BaseController{

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IRoleService roleService;


    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;

    @RequiredPermission("查看客户资源池")
    @RequestMapping("/customerResourcePool")
    public String index() {
        return "customerResourcePool";
    }

    @RequestMapping("/customerResourcePool_list")
    @ResponseBody
    public PageResult list(CustomerResourcePoolQueryObject qo) {
        PageResult result = null;
        Employee e = (Employee) UserContext.getLocalRequest().getSession().getAttribute(UserContext.USER_IN_SESSION);

        try {

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {

            qo.setUserId(e.getId());
            result = customerService.queryResourcePoolByCondition(qo);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/customerResourcePool_query")
    @ResponseBody
    public List<SystemDictionaryItem> queryBySn(String sn) {
        return systemDictionaryItemService.queryBySn(sn);

    }

    @RequestMapping("/customerResourcePool_save")
    @ResponseBody
    public AjaxResult save(Customer c) {
        Employee employee = (Employee) UserContext.getLocalRequest().getSession().getAttribute(UserContext.USER_IN_SESSION);

        AjaxResult result = null;
        try {
            c.setStatus(0);
            c.setInputtime(new Date());
            c.setInputuser(employee);
            c.setInchargeuser(employee);
            int effectCount = customerService.save(c);

            if (effectCount > 0) {
                result = new AjaxResult(true, "保存成功");
            } else {
                result = new AjaxResult(true, "保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(true, "保存异常");
        }

        return result;
    }

    @RequestMapping("/customerResourcePool_update")
    @ResponseBody
    public AjaxResult update(Customer c) {
//        Employee employee = (Employee) UserContext.getLocalRequest().getSession().getAttribute(UserContext.USER_IN_SESSION);

        AjaxResult result = null;
        try {
            c.setStatus(0);
            int effectCount = customerService.update(c);

            if (effectCount > 0) {
                result = new AjaxResult(true, "更新成功");
            } else {
                result = new AjaxResult(true, "更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(true, "更新异常");
        }

        return result;
    }


    @RequestMapping("/customer_admit")
    @ResponseBody
    public AjaxResult customerAdmit(Long id) {
        Employee employee = (Employee) UserContext.getLocalRequest().getSession().getAttribute(UserContext.USER_IN_SESSION);

        AjaxResult result = null;
        try {
            int effectCount = customerService.customerAdmit(employee.getId(), id);

            if (effectCount > 0) {
                result = new AjaxResult(true, "吸纳成功");
            } else {
                result = new AjaxResult(true, "吸纳失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(true, "吸纳异常");
        }

        return result;
    }


}
