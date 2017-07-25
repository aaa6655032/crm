package com._520it.crm.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com._520it.crm.domain.KnowledgeMenu;
import com._520it.crm.service.IKnowledgeMenuService;



//客户知识库
@Controller
public class KnowledgeController {
	@Autowired
	private IKnowledgeMenuService knowledgeMenuService;
	
	//界面
    @RequestMapping("/knowledge")
	public String index(){
		return "knowledge";
		
	}
    
   //菜单列表
    @RequestMapping("/knowledgeMenu")
    @ResponseBody
     public List<KnowledgeMenu> list(){
    	List<KnowledgeMenu> result = null;
    	result = knowledgeMenuService.queryKnowledgeMenu();
		return result;
    }
   
    
}
