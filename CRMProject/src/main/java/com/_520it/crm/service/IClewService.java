package com._520it.crm.service;

import com._520it.crm.domain.Clew;
import com._520it.crm.page.PageResult;
import com._520it.crm.query.ClewQueryObject;

/**
 * Created by Administrator on 2016/9/22.
 */
public interface IClewService {
    int save(Clew c);

    int delete(Long id);

    Clew get(Long id);

    int update(Clew c);

    PageResult listAll();


    void luceneWriteIndex();

    PageResult querybyLuceneAll(String keyword);

    public PageResult querybyLuceneCondition(ClewQueryObject qo);

    int deleteLuceneById(Long id);

    int reload();

    String getContentById(Long id);
}
