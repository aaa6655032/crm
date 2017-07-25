package com._520it.crm.web.controller;

import com._520it.crm.domain.Customer;
import com._520it.crm.domain.CustomerTransfer;
import com._520it.crm.domain.Employee;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.CustomerTransferQueryObject;
import com._520it.crm.service.ICustomerService;
import com._520it.crm.service.ICustomerTransferService;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.util.RequiredPermission;
import com._520it.crm.util.UserContext;
import com._520it.crm.vo.CustomerTransferVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by Administrator on 2016/9/20.
 */
@Controller
public class CustomerTransferController extends BaseController{


    @Autowired
    private ICustomerTransferService customerTransferService;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IEmployeeService employeeService;

    @RequiredPermission("查看客户移交")
    @RequestMapping("/customerTransfer")
    public String index() {
        System.out.println("IndexController.employeeList");
        return "customerTransfer";
    }

    @RequestMapping("/customerTransfer_list")
    @ResponseBody
    public PageResult list(CustomerTransferQueryObject qo) {
        PageResult result = null;
        result = customerTransferService.queryByCondition(qo);
        return result;
    }


    @RequestMapping("/customerTransfer_save")
    @ResponseBody
    public AjaxResult save(CustomerTransferVO vo) {
        Employee employee = (Employee) UserContext.getLocalRequest().getSession().getAttribute(UserContext.USER_IN_SESSION);
        AjaxResult result = null;
        // 移交的客户
        Customer c = customerService.get(vo.getCustomerId());
        // 新市场专员
        Employee emp = employeeService.get(vo.getInchargeuserId());
        try {
            //创建移交对象,再共享的时候
            CustomerTransfer transfer = new CustomerTransfer();
            transfer.setCustomer(c);
            transfer.setOldseller(c.getInchargeuser());
            transfer.setNewseller(emp);
            transfer.setTranstime(new Date());
            transfer.setTransuser(employee);
            transfer.setTransreason(vo.getReason());
            // 创建移交记录
            customerTransferService.save(transfer);

            // 根据客户的ID去修改该客户的市场专员
            int effectCount = customerService.updateByChargeId(c.getId(), vo.getInchargeuserId());
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

}


