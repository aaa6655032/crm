package com._520it.crm.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
@Alias("Salary")
public class Salary {
	
    private Long id;
    private Long eid ;
   private BigDecimal salary;
  //  private Integer salary;
    private Employee employee;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date date;
    
    @DateTimeFormat(pattern = "yyyy")
    @JsonFormat(pattern = "yyyy", timezone = "GMT+8")
    private Date year ;
    
    @DateTimeFormat(pattern = "MM")
    @JsonFormat(pattern = "MM", timezone = "GMT+8")
    private Date month ;
    
}