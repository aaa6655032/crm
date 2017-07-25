package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2016/9/14.
 */
public class QueryObject {
    @Setter
    @Getter
    private Integer page; // 当前页
    @Setter
    @Getter
    private Integer rows; // 每页最多显示多少条

    // 分页时每页的起始行
    private Integer getStart() {
        return (this.page - 1) * this.rows;
    }
}
