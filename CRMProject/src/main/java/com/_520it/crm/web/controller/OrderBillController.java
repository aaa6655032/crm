package com._520it.crm.web.controller;

import com._520it.crm.domain.Contract;
import com._520it.crm.domain.Customer;
import com._520it.crm.domain.Employee;
import com._520it.crm.domain.OrderBill;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.OrderBillQueryObject;
import com._520it.crm.service.IContractService;
import com._520it.crm.service.IOrderBillService;
import com._520it.crm.util.RequiredPermission;
import com._520it.crm.util.UserContext;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.UUID;

/**
 * Created by ShikieikiSama丶 on 2016/9/20.
 */

@Controller
public class OrderBillController extends BaseController{

    @Autowired
    private IOrderBillService orderBillService;

    @Autowired
    private IContractService contractService;

    @RequestMapping("/orderBill")
    public String index() {
        return "orderBill";
    }

    @RequestMapping("/orderBill_list")
    @ResponseBody
    public PageResult list(OrderBillQueryObject qo) {
        PageResult result = null;
        result = orderBillService.queryByCondition(qo);
        return result;
    }


    //订单保存
    @RequestMapping("/orderBill_save")
    @ResponseBody
    public AjaxResult save(OrderBill orderBill, MultipartFile pic, HttpServletRequest request) {
        String filePath = MulipartFileUpload(pic, request);
        AjaxResult result = null;
        try {
            //保存路径至数据库
            orderBill.setFile(filePath);
            orderBill.setCreatetime(new Date());
            orderBill.setStatus(0);
            int effectCount = orderBillService.insert(orderBill);
            if (effectCount > 0) {
                return new AjaxResult(true, "保存成功");
            } else {
                return new AjaxResult("保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new AjaxResult("保存出现异常,请联系管理员");
        }
    }


    //抽取共同的springMVC图片上传方法
    private String MulipartFileUpload(MultipartFile pic, HttpServletRequest request) {
        String realPath1 = request.getSession().getServletContext().getRealPath("/upload");
        String realPath2 = realPath1.replace("\\", "/") + "/";
        String realName1 = UUID.randomUUID() + "." + pic.getContentType().split("/")[1];
        String realName2 = "/upload/" + realName1;
        //springMVC图片上传
        if (pic != null) {
            InputStream inputStream = null;
            FileOutputStream outputStream = null;
            try {
                inputStream = pic.getInputStream();
                outputStream = new FileOutputStream(new File(realPath2 + realName1));
                IOUtils.copy(inputStream, outputStream);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (inputStream != null)
                        inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (outputStream != null)
                            outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return realName2;
    }

    //订单修改
    @RequestMapping("/orderBill_update")
    @ResponseBody
    public AjaxResult update(OrderBill orderBill, HttpSession session, MultipartFile pic, HttpServletRequest request) {
        String filePath = MulipartFileUpload(pic, request);
        AjaxResult result = null;
        try {
            Employee employee = (Employee) session.getAttribute(UserContext.USER_IN_SESSION);
            orderBill.setModifyuser(employee);
            orderBill.setModifytime(new Date());
            orderBill.setFile(filePath);
            int effectRows = orderBillService.updateByPrimaryKey(orderBill);
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


    //订单删除
    @RequestMapping("/orderBill_delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            int row = orderBillService.deleteByPrimaryKey(id);
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


    //订单审核
    @RequiredPermission("订单审核")
    @RequestMapping("/orderBill_checked")
    @ResponseBody
    public AjaxResult checked(Long id) {
        AjaxResult result = null;
        try {
            int row = orderBillService.checked(id);
            if (row > 0) {
                result = new AjaxResult(true, "审核成功");
            } else {
                result = new AjaxResult(false, "审核失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "审核异常");
        }
        return result;
    }

    @RequiredPermission("部门订单审核")
    public void departmentChecked(){

    }

    @RequiredPermission("财务订单审核")
    public void financeChecked(){

    }


    //拒绝订单审核
    @RequestMapping("/orderBill_noChecked")
    @ResponseBody
    public AjaxResult noChecked(Long id) {
        AjaxResult result = null;
        try {
            int row = orderBillService.noChecked(id);
            if (row > 0) {
                result = new AjaxResult(true, "拒绝审核成功");
            } else {
                result = new AjaxResult(false, "拒绝审核失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "拒绝审核异常");
        }
        return result;
    }

    //生成合同
    @RequestMapping("/orderBill_doContract")
    @ResponseBody
    public AjaxResult doContract(Long id, Contract contract) {
        AjaxResult result = null;
        OrderBill orderBill = orderBillService.selectByPrimaryKey(id);
        Customer customer = orderBill.getCustomer();
        Employee seller = orderBill.getSeller();
        String file = orderBill.getFile();
        orderBillService.updateStatus(id);

        contract.setSn(UUID.randomUUID().toString());
        contract.setCustomer(customer);
        contract.setSeller(seller);
        contract.setSigntime(new Date());
        contract.setStatus(0);
        contract.setFile(file);
        try {
            int row = contractService.insert(contract);
            if (row > 0) {
                result = new AjaxResult(true, "合同生成成功");
            } else {
                result = new AjaxResult(false, "合同生成失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "合同生成出现异常");
        }
        return result;
    }

    //更新前预处理(避免file和sn丢失.)
    @ModelAttribute
    public void before(Long id, Model model) {
        if (id != null) {
            OrderBill orderBill = orderBillService.selectByPrimaryKey(id);
            model.addAttribute(orderBill);
        }
    }
}
