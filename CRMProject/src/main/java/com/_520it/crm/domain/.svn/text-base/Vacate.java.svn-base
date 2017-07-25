package com._520it.crm.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Setter @Getter
@Alias("Vacate")
public class Vacate {
	public static final int NORMAL = 0; //未审核
	public static final int AUDIT = 1; //已审核

	
    private Long id;
    private int state;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date begintime;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date endtime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date audittime;
    
    private Employee employee;
    private Employee audit;
	@Override
	public String toString() {
		return "Vacate [id=" + id + ", state=" + state + ", begintime="
				+ begintime + ", endtime=" + endtime + ", audittime="
				+ audittime + "]";
	}
    
    

    
}