package com._520it.crm.domain;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;


@Setter @Getter
@Alias("CheckIn")
public class CheckIn {
	
	public static final Integer SIGNSTATE_NORMAL = 1 ;
    public static final Integer SIGNSTATE_LATE = 2 ;
    public static final Integer SIGNSTATE_EARLY= 3 ;
    public static final Integer SIGNSTATE_LATEANDEARLY= 4 ;
	
	//private int checkid; //表示用来判断是补签修改还是 新增补签
    
    private Long id;
    private String userip;
    private int state;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date signintime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date signouttime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date checktime;
    
    private Employee employee;
    private Employee checkman;
	@Override
	public String toString() {
		return "CheckIn [id=" + id + ", userip=" + userip + ", state=" + state
				+ ", signintime=" + signintime + ", signouttime=" + signouttime
				+ ", checktime=" + checktime + "]";
	}
    
    

}