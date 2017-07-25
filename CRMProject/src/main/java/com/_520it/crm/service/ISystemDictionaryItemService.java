package com._520it.crm.service;

import com._520it.crm.domain.SystemDictionaryItem;
import com._520it.crm.page.PageResult;

import java.util.List;

/**
 * Created by Administrator on 2016/9/18.
 */
public interface ISystemDictionaryItemService {

    int save(SystemDictionaryItem e);

    int delete(Long id);

    SystemDictionaryItem get(Long id);

    int update(SystemDictionaryItem e);

    List<SystemDictionaryItem> listAll();

    PageResult selectByPid(Long id);


    int forbiddenStateById(Long id);

    int startStateById(long id);

    List<SystemDictionaryItem> queryBySn(String sn);
}

