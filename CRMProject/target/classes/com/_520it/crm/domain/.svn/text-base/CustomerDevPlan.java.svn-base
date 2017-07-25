package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Setter
@Getter
@Alias("CustomerDevPlan")
public class CustomerDevPlan {
    private Long id;  // 编号
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date plantime; // 计划时间
    private String plansubject; //  计划主题
    private String plantype; // 计划实施方式 :电话,邀约上门
    private String plandetails;// 计划内容
    private Integer traceresult;//优--3,中--2,差--1
    private String remark; //备注
    private Customer customer; // 潜在客户
    private Employee inputuser; //创建人
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date inputtime; //创建时间
    private Integer type; // 类型:0:潜在开发计划;1:客户跟进历史

}