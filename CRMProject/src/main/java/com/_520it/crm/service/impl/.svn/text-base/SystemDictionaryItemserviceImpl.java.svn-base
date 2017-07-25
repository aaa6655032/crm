package com._520it.crm.service.impl;

import com._520it.crm.domain.SystemDictionaryItem;
import com._520it.crm.mapper.SystemDictionaryItemMapper;
import com._520it.crm.page.PageResult;
import com._520it.crm.service.ISystemDictionaryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/18.
 */
@Service
public class SystemDictionaryItemserviceImpl implements ISystemDictionaryItemService {

    @Autowired
    private SystemDictionaryItemMapper dao;


    @Override
    public int save(SystemDictionaryItem item) {
        return dao.insert(item);
    }

    @Override
    public int delete(Long id) {
        return dao.deleteByPrimaryKey(id);
    }

    @Override
    public SystemDictionaryItem get(Long id) {
        return dao.selectByPrimaryKey(id);
    }

    @Override
    public int update(SystemDictionaryItem item) {
        return dao.updateByPrimaryKey(item);
    }

    @Override
    public List<SystemDictionaryItem> listAll() {
        return null;
    }

    @Override
    public PageResult selectByPid(Long id) {
        return new PageResult(Long.parseLong(dao.selectAll().size()+""), dao.selectByPid(id));
    }

    @Override
    public int forbiddenStateById(Long id) {
        return dao.forbiddenStateById(id);
    }

    @Override
    public int startStateById(long id) {
        return dao.startStateById(id);
    }

    @Override
    public List<SystemDictionaryItem> queryBySn(String sn) {
        return dao.queryBySn(sn);
    }


}
