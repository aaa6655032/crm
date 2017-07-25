package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by Administrator on 2016/9/16.
 */
@Setter
@Getter
public class DepartmentQueryObject extends QueryObject {

    private String keyword;
    private Boolean state;
}
