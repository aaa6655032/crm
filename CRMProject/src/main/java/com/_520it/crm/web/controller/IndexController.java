package com._520it.crm.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/9/13.
 */
@Controller
public class IndexController extends BaseController {


    @RequestMapping("/index")
    public String index() {
        System.out.println("IndexController.method");
        return "index";
    }


}
