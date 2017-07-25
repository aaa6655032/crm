package com._520it.crm.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.springframework.beans.factory.annotation.Autowired;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.SystemLog;
import com._520it.crm.service.ISystemLogService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Administrator on 2016/9/15.
 */

public class LogUtil {

    @Autowired
    private ISystemLogService systemLogService;


    public void writeLog(JoinPoint joinPoint) throws Exception {

        // 判断被AOP切面的累是否为ISystemLogService,如果是的话直接跳过,不然会出现死循环
        if(joinPoint.getTarget() instanceof ISystemLogService){
            return;
        }

        HttpServletRequest localRequest = UserContext.getLocalRequest();
        SystemLog systemLog = new SystemLog();
        // 设置操作的时间
        systemLog.setOptime(new Date());
        // 设置当前操作的用户
        Employee localUser = (Employee) localRequest.getSession().getAttribute(UserContext.USER_IN_SESSION);
        systemLog.setOpUser(localUser);
        // 获取发起请求的IP地址
        systemLog.setOpip(localRequest.getRemoteAddr());
        // 被AOP切面的类 :eg: com._520it.crm.service.impl.EmployeeServiceImpl
        Object target = joinPoint.getTarget();
        // 被AOP切面类中的方法 eg:queryByLogin
        Signature signature = joinPoint.getSignature();
        //全定限类名:方法名 function = com._520it.crm.service.impl.EmployeeServiceImpl:queryByLogin
        String function = target.getClass().getName() + ":" + signature.getName();
        // 设置当前的操作的类和方法
        systemLog.setFunction(function);
        // 设置传入方法的参数对象 :args = [Ljava.lang.Object;@244f22a3
        Object[] args = joinPoint.getArgs();
        // 把类中的对象转换为json对象的方法
        ObjectMapper mapper = new ObjectMapper();
        // 空的参数就不要转换为json字符串
        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        // 把参数对象转换为json个数的字符串:mapper = ["admin","1"]
        String paramValue = mapper.writeValueAsString(args);
        // 设置当前的参数到日志中
        systemLog.setParams(paramValue);
        System.out.println("paramValue = " + paramValue);
        // 保存日志到数据库中
        systemLogService.save(systemLog);


    }
}
