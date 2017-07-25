package com._520it.crm.domain;

import java.util.Date;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
@Setter@Getter
@Alias("GuaranteeItem")
public class GuaranteeItem {
    private Long id;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date guaranteetime;//保修时间
    private String content;//保修内容
    private Integer status;//状态
    private Integer cost;//保修费用
    private Guarantee guarantee;//保修单号

   
}