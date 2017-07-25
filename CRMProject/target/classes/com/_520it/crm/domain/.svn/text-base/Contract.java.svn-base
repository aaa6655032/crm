package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


@Getter
@Setter
public class Contract {
    private Long id;

    private String sn;//合同单号

    private Customer customer;//合同客户
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date signtime;//签订时间

    private Employee seller;//营销人员

    private String contractsum;//合同金额

    private String money;//付款金额
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date paytime;//付款时间

    private String intro;//合同摘要

    private Integer status;//审核状态

    private String file;//附件

    private Employee modifyuser;//最近修改人
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modifytime;//最近修改时间
}