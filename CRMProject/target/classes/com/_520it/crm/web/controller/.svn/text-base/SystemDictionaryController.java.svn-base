package com._520it.crm.web.controller;

import com._520it.crm.domain.SystemDictionaryItem;
import com._520it.crm.page.AjaxResult;
import com._520it.crm.page.PageResult;
import com._520it.crm.service.ISystemDictionaryItemService;
import com._520it.crm.service.ISystemDictionaryService;
import com._520it.crm.util.RequiredPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/9/18.
 */
@Controller
public class SystemDictionaryController extends BaseController{

    @Autowired
    private ISystemDictionaryService systemDictionaryService;

    @Autowired
    private ISystemDictionaryItemService systemDictionaryItemService;

    @RequiredPermission("数据字典查询")
    @RequestMapping("/systemDictionary")
    public String index() {
        return "systemDictionary";
    }

    @RequestMapping("/dictionary_list")
    @ResponseBody
    public PageResult dictionaryList() {
        return systemDictionaryService.listAll();
    }


    @RequestMapping("/queryByDictionaryId")
    @ResponseBody
    public PageResult queryByDictionaryId(Long id) {

        return systemDictionaryItemService.selectByPid(id);
    }

    @RequestMapping("/dictionaryItem_save")
    @ResponseBody
    public AjaxResult save(SystemDictionaryItem item) {
        AjaxResult result = null;
        try {
            int effectCount = systemDictionaryItemService.save(item);
            if(effectCount >0){
            result = new AjaxResult(true,"保存成功");
            }else{
                result = new AjaxResult(false,"保存失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false,"保存异常");
        }
        return result;
    }

    @RequestMapping("/dictionaryItem_update")
    @ResponseBody
    public AjaxResult update(SystemDictionaryItem item) {
        AjaxResult result = null;
        try {
            int effectCount = systemDictionaryItemService.update(item);
            if(effectCount >0){
                result = new AjaxResult(true,"更新成功");
            }else{
                result = new AjaxResult(false,"更新失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false,"更新异常");
        }
        return result;
    }
    @RequestMapping("/dictionaryItem_delete")
    @ResponseBody
    public AjaxResult delete(Long id) {
        AjaxResult result = null;
        try {
            int effectCount = systemDictionaryItemService.delete(id);
            if(effectCount >0){
                result = new AjaxResult(true,"删除成功");
            }else{
                result = new AjaxResult(false,"删除失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false,"删除异常");
        }
        return result;
    }


    @RequestMapping("/dictionaryItem_forbidden")
    @ResponseBody
    public AjaxResult forbidden(Long id) {
        AjaxResult result = null;
        try {
            int effectCount = systemDictionaryItemService.forbiddenStateById(id);
            if(effectCount >0){
                result = new AjaxResult(true,"禁用成功");
            }else{
                result = new AjaxResult(false,"禁用失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false,"禁用异常");
        }
        return result;
    }
    @RequestMapping("/dictionaryItem_start")
    @ResponseBody
    public AjaxResult start(Long id) {
        AjaxResult result = null;
        try {
            int effectCount = systemDictionaryItemService.startStateById(id);
            if(effectCount >0){
                result = new AjaxResult(true,"启用成功");
            }else{
                result = new AjaxResult(false,"启用失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            result = new AjaxResult(false,"启用异常");
        }
        return result;
    }

}
