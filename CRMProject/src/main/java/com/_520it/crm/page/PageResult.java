package com._520it.crm.page;

import lombok.Getter;
import lombok.Setter;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/9/14.
 */
@Setter
@Getter
public class PageResult {
    private Long total; // 总条数
    private List rows; // 结果集
    private Map<String,Object> data=new HashMap();
    public static final PageResult EMPTY = new PageResult(0L, Collections.EMPTY_LIST); // 空的结果集

    public PageResult(Long total, List rows) {
        this.total = total;
        this.rows = rows;
    }

    public PageResult() {
    }
}
