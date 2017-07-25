package com._520it.crm.service.impl;

import com._520it.crm.domain.Menu;
import com._520it.crm.mapper.MenuMapper;
import com._520it.crm.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    private MenuMapper dao;

    @Override
    public List<Menu> queryMenu() {
        return dao.selectRoot();
    }
}
