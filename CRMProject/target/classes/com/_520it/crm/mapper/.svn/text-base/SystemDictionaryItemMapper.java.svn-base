package com._520it.crm.mapper;

import com._520it.crm.domain.SystemDictionaryItem;

import java.util.List;

public interface SystemDictionaryItemMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SystemDictionaryItem record);

    SystemDictionaryItem selectByPrimaryKey(Long id);

    List<SystemDictionaryItem> selectAll();

    int updateByPrimaryKey(SystemDictionaryItem record);

    List<SystemDictionaryItem> selectByPid(Long id);

    int forbiddenStateById(Long id);

    int startStateById(Long id);

    List<SystemDictionaryItem> queryBySn(String sn);

   /* List<SystemDictionaryItem> queryBySalaryLevel();

    List<SystemDictionaryItem> queryByCustomerSource();*/

}