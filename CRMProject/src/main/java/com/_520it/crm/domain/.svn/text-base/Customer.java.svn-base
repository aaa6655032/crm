package com._520it.crm.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.util.Date;

@Setter
@Getter
@Alias("Customer")
public class Customer {
    private Long id; // 编号
    private String name; // 姓名
    private Integer age; // 年龄
    private Integer gender; //性别:
    private String tel; // 电话
    private String email; // 邮箱
    private String qq; // QQ
    private String wechat; // 微信
    private String job; // 职业
    private String salarylevel; // 收入水平
    private String customersource;//客户来源
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date inputtime; //创建时间
    private Integer status; // 状态
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date becometime; //转正时间
    private Employee inputuser; //创建人
    private Employee inchargeuser;//负责人

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                ", qq='" + qq + '\'' +
                ", wechat='" + wechat + '\'' +
                ", job='" + job + '\'' +
                ", salarylevel='" + salarylevel + '\'' +
                ", customersource='" + customersource + '\'' +
                ", inputtime=" + inputtime +
                ", status=" + status +
                ", becometime=" + becometime +
                '}';
    }
}