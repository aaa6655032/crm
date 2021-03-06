package com._520it.crm.query;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 */
@Getter
@Setter
@ToString
public class NetworkDiskQueryObject extends QueryObject {

    private String keyword;

    private Long pid;

    private Long currentId;
}
