package com._520it.crm.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;
@Setter @Getter 
@Alias("Attendance")
public class Attendance {
	
    private Long id;
    private Employee employee;
    private Long signinday;
    private Long lateday;
    private Long earlyday;
    private Long vacateday;
    
    @DateTimeFormat(pattern = "yyyy-MM")
    @JsonFormat(pattern = "yyyy-MM", timezone = "GMT+8")
    private Date date;
  
}