package com._520it.crm.web.controller;

import com._520it.crm.page.PageResult;
import com._520it.crm.query.PermissionQueryObject;
import com._520it.crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/9/15.
 */
@Controller
public class PermissionController extends BaseController {

    @Autowired
    private IPermissionService permissionService;


    @RequestMapping("/permission_list")
    @ResponseBody
    public PageResult list(PermissionQueryObject qo) {
        PageResult result = null;
        try {
            result = permissionService.queryByCondition(qo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping("/permission_reload")
    @ResponseBody
    public void reload() {

        permissionService.reload();

    }

}
