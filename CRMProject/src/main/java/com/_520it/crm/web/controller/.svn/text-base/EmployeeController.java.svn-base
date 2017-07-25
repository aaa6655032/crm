package com._520it.crm.web.controller;


import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Menu;
import com._520it.crm.domain.Permission;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.EmployeeQueryObject;
import com._520it.crm.service.IEmployeeService;
import com._520it.crm.service.IMenuService;
import com._520it.crm.service.IPermissionService;
import com._520it.crm.util.PermissionUtils;
import com._520it.crm.util.RequiredPermission;
import com._520it.crm.util.UserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/9/14.
 */
@Controller
public class EmployeeController extends BaseController {

    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private IMenuService menuService;

    @RequestMapping("/login")
    @ResponseBody
    public AjaxResult login(String username, String password, HttpServletRequest request) {
        // 设置请求到当前的线程中
        UserContext.setLocalThread(request);
        AjaxResult result = null;
        Employee employee = employeeService.queryByLogin(username, password);
        if (employee != null) {
            // 把当前用户放到session中
            request.getSession().setAttribute(UserContext.USER_IN_SESSION, employee);
            // 查询该用户拥有的权限,并放到session中
            List<Permission> permissions = permissionService.queryPermissionByEid(employee.getId());
            request.getSession().setAttribute(UserContext.PERMISSION_IN_SESSION, permissions);
            // 根据用户拥有的权限来加载菜单
            List<Menu> userMenus = menuService.queryMenu();
            PermissionUtils.getMenuForPermission(userMenus);
            // 把用户的加载菜单放到session中
            request.getSession().setAttribute(UserContext.MENU_IN_SESSION, userMenus);
            request.getSession().setAttribute("username", employee.getUsername());
            result = new AjaxResult(true);
        } else {
            result = new AjaxResult(false, "账号或者密码不正确");
        }
        return result;
    }


    @RequestMapping("/employee")
    public String index() {
        System.out.println("IndexController.employeeList");
        return "employee";
    }


    /*
     springMVC+hibernate 集成时用来预处理的方法:
     @ModelAttribute:这个标签就会在执行每个方法之前执行这个代码
     Model model :用来传参:把对象信息传递给另外的方法
     */

    @ModelAttribute
    public void before(Long id, Model model) {

       /* if(id !=null){
            Employee emp = new Employee();
            emp.setPassword("9999999999");
            model.addAttribute(emp);
        }*/

    }

    @RequestMapping("/employee_queryRoleIdByEid")
    @ResponseBody
    public List<Long> getRoleId(Long eid) {
        return employeeService.queryByRoleIdByEid(eid);
    }


    @RequestMapping("/employee_list")
    @ResponseBody
    public PageResult list(EmployeeQueryObject qo) {
        PageResult result = null;
        result = employeeService.queryByCondition(qo);
        return result;
    }

    @RequestMapping("/employee_delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {

            int row = employeeService.delete(id);
            if (row > 0) {
                result = new AjaxResult(true, "离职成功");

            } else {
                result = new AjaxResult(false, "离职失败");

            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false, "离职异常");
        }
        return result;

    }

    @RequestMapping("/employee_save")
    @ResponseBody
    public AjaxResult save(Employee e) {
        AjaxResult result = null;
        try {
            e.setAdmin(false);
            e.setPassword("888888");
            e.setInputtime(new Date());
            e.setState(true);
            int effectRows = employeeService.save(e);
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

    @RequestMapping("/employee_update")
    @ResponseBody
    public AjaxResult update(Employee e) {
        AjaxResult result = null;
        try {
            e.setInputtime(new Date());
            int effectRows = employeeService.update(e);
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


    @RequestMapping("/manager_list")
    @ResponseBody
    public PageResult managerList() {
        PageResult result = null;
        result = employeeService.selectMangerList();

        return result;

    }

    @RequestMapping("/seller_list")
    @ResponseBody
    public PageResult sellerList() {
        PageResult result = null;
        result = employeeService.sellerList();
        return result;
    }

    /*根据潜在客户查询负责人*/
    @RequestMapping("/selectByPotential")
    @ResponseBody
    public List<Employee> selectByPotential() {
        return employeeService.selectByPotential();
    }

    /*根据正式客户查询负责人*/
    @RequestMapping("/selectByCustomer")
    @ResponseBody
    public List<Employee> selectByCustomer() {
        return employeeService.selectByCustomer();
    }


    /*根据正式客户查询负责人*/
    @RequestMapping("/incharge_list")
    @ResponseBody
    public List<Employee> selectByInCharge() {
        return employeeService.selectByInCharge();
    }


    @RequiredPermission("系统管理员")
    public void manager() {

    }


}
