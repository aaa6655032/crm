package com._520it.crm.service.impl;

import com._520it.crm.mapper.SystemDictionaryMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.service.ISystemDictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/9/18.
 */
@Service
public class SystemDictionServiceImpl implements ISystemDictionaryService {

    @Autowired
    private SystemDictionaryMapper dao;


    @Override
    public PageResult listAll() {
        return new PageResult(Long.parseLong(dao.selectAll().size()+""), dao.selectAll());
    }
}
