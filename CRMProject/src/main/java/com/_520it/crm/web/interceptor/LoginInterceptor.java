package com._520it.crm.web.interceptor;

import com._520it.crm.domain.Employee;
import com._520it.crm.util.PermissionUtils;
import com._520it.crm.util.UserContext;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2016/9/14.
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object target) throws Exception {
        Employee current = (Employee) request.getSession().getAttribute(UserContext.USER_IN_SESSION);
        // 设置请求到当前的线程中
        UserContext.setLocalThread(request);

        if (current != null) {
            //如果
            if (target instanceof HandlerMethod) {
                //获取拦截目标的类型和方法
                HandlerMethod hadler = (HandlerMethod) target;
                String ClassName = hadler.getBean().getClass().getName();
                String methodName = hadler.getMethod().getName();
                // 把拦截的类和方法拼接成权限表单式
                String function = ClassName + ":" + methodName;
                // 如果返回为true,表示用户拥有这个权限访问该方法或者该方法不受权限控制,直接放行
                // 如果为false,拦截该请求
                if (PermissionUtils.checkPermission(function)) {
                    return true;
                } else {
                    // 如果请求的内容是页面的话,跳转到nopermissions.jsp页面,
                    // 如果请求的是Ajax数据的话,跳转到nopermissions.json
                    if (hadler.getMethod().isAnnotationPresent(ResponseBody.class)) {
                        response.sendRedirect("/nopermission.json");
                    } else {
                        response.sendRedirect("/nopermission.jsp");
                    }
                    System.out.println(request.getRequestURI());

                    return false;
                }
            }
        } else {
            response.sendRedirect("/login.jsp");
            return false;
        }
            return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
