package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
@Alias("OrderBill")
public class OrderBill {
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signtime;//签订时间

    private Customer customer;//定金客户

    private Employee seller;//营销人员

    private String totalsum;//总金额

    private String bargainmoney;//定金金额

    private String intro;//摘要

    private String file;//附件
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createtime;//创建时间

    private Employee modifyuser;//最近修改人
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modifytime;//最近修改时间

    private Integer status;//订单状态
}