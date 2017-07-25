package com._520it.crm.web.controller;

import com._520it.crm.domain.Customer;
import com._520it.crm.domain.CustomerTransfer;
import com._520it.crm.domain.Employee;
import com._520it.crm.domain.SystemDictionaryItem;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.PotentialCustomerQueryObject;
import com._520it.crm.service.*;
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
public class PotentialCustomerController extends BaseController{

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private ICustomerTransferService transferService;

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;

    @RequiredPermission("查看潜在客户")
    @RequestMapping("/potentialCustomer")
    public String index() {
        return "potentialCustomer";
    }

    @RequestMapping("/potentialCustomer_list")
    @ResponseBody
    public PageResult list(PotentialCustomerQueryObject qo) {
        PageResult result = null;
        Employee e = (Employee) UserContext.getLocalRequest().getSession().getAttribute(UserContext.USER_IN_SESSION);

        try {

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        try {

            qo.setUserId(e.getId());
            result = customerService.queryByCondition(qo);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/potentialCustomer_query")
    @ResponseBody
    public List<SystemDictionaryItem> queryBySn(String sn) {
        return systemDictionaryItemService.queryBySn(sn);

    }

    @RequestMapping("/potentialCustomer_save")
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

    @RequestMapping("/potentialCustomer_update")
    @ResponseBody
    public AjaxResult update(Customer c) {

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

    @RequestMapping("/potential_updateInCharge")
    @ResponseBody
    public AjaxResult updateInCharge(Customer c, Long inchargeId, String reason) {
        // 获取当前登录对象
        Employee employee = (Employee) UserContext.getLocalRequest().getSession().getAttribute(UserContext.USER_IN_SESSION);

        AjaxResult result = null;
        if (c.getInchargeuser().getId() == inchargeId) {
            result = new AjaxResult(false, "您不能自己共享或移交给自己");
            return result;
        }
        try {
            //创建移交对象,再共享的时候
            CustomerTransfer transfer = new CustomerTransfer();
            transfer.setCustomer(c);
            transfer.setOldseller(c.getInchargeuser());
            transfer.setNewseller(employeeService.get(inchargeId));
            transfer.setTranstime(new Date());
            transfer.setTransuser(employee);
            transfer.setTransreason(reason);
            // 创建移交记录
            transferService.save(transfer);

            int effectCount = customerService.updateByChargeId(c.getId(), inchargeId);
            if (effectCount > 0) {
                result = new AjaxResult(true, "操作成功");
            } else {
                result = new AjaxResult(false, "操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "操作异常");
        }

        return result;

    }


    @RequestMapping("/potentialCustomer_developFalse")
    @ResponseBody
    public AjaxResult developFalse(Long id) {
        AjaxResult result = null;
        try {
            int effectCount = customerService.updateStatusFalseById(id);

            if (effectCount > 0) {
                result = new AjaxResult(true, "操作成功");
            } else {
                result = new AjaxResult(true, "操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(true, "操作异常");
        }

        return result;
    }

    @RequestMapping("/potentialCustomer_become")
    @ResponseBody
    public AjaxResult become(Long id) {
        AjaxResult result = null;
        try {
            int effectCount = customerService.updateStatusSuccessById(id);

            if (effectCount > 0) {
                result = new AjaxResult(true, "操作成功");
            } else {
                result = new AjaxResult(true, "操作失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(true, "操作异常");
        }

        return result;
    }

}
