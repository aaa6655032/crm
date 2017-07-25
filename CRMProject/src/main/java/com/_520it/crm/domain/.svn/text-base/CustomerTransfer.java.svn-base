package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Setter
@Getter
@Alias("CustomerTransfer")
public class CustomerTransfer {
    private Long id;
    private Customer customer;  // 客户
    private Employee transuser; // 移交人员
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date transtime; // 移交时间
    private Employee oldseller; // 旧市场专员
    private Employee newseller; // 新市场专员
    private String transreason; //移交的原因


}