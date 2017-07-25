package com._520it.crm.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
@Setter@Getter
@Alias("Guarantee")
public class Guarantee {
    private Long id;
    private String sn;//保修单号
    private String productname;//产品名称
    private Customer customer;//保修客户
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date duetime;//质保到期时间
    private String remark;//备注
	@Override
	public String toString() {
		return "Guarantee [id=" + id + ", sn=" + sn + ", productname="
				+ productname + ", duetime=" + duetime + ", remark=" + remark
				+ "]";
	}
  
    
}