package com._520it.crm.util;

import com._520it.crm.domain.Employee;
import com._520it.crm.domain.Menu;
import com._520it.crm.domain.Permission;
import com._520it.crm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by Administrator on 2016/9/17.
 */
@Component
public class PermissionUtils {

    private static IPermissionService permissionService;

    public static boolean checkPermission(String function) {
    	
        Employee current = (Employee) UserContext.getLocalRequest().getSession().getAttribute(UserContext.USER_IN_SESSION);

        //1:该用户是超级管理员的话,返回true,直接放行
        if (current.getAdmin()!= null &&current.getAdmin()) {
            return true;
        }
        //2:根据访问的方法的权限表单式去数据库权限表中查询,如果数据库存在则需要权限控制,数据库不存在,则不需要控制,直接放行
        Permission p = permissionService.queryByResource(function);

        if (p != null) {
            //3:查询该用户是否拥有该方法的权限
            List<Permission> permissions = permissionService.queryPermissionByEid(current.getId());
            String allFunction = function.split(":")[0] + ":" + "All";
            for (Permission permission : permissions) {
                //4:如果用户拥有该权限或者拥有该类型的All权限,则放行
                if (permission.getResource().equals(function) || permission.getResource().equals(allFunction)) {
                    return true;
                }
            }
            // 不满足,则拦截
            return false;
        } else {
            return true;
        }

    }

    // 因为字段为static,不能直接注入,所以注入到setter方法上
    @Autowired
    public void setPermissionService(IPermissionService permissionService) {
        PermissionUtils.permissionService = permissionService;
    }

    // 根据用户的权限来获取菜单
    public static void getMenuForPermission(List<Menu> userMenus) {

        for (int i = userMenus.size() - 1; i >= 0; i--) {
            // 检查用户是否有这个菜单的权限
            Menu menu = userMenus.get(i);
            if (checkPermission(menu.getResource())) {
                if (menu.getChildren() != null && menu.getChildren().size() > 0) {
                    getMenuForPermission(menu.getChildren());
                }
            } else {
                // 用户没有这个权限则删除该权限
                userMenus.remove(i);
            }
        }

    }
	// 拼接方法的权限表达式
	public static String buildResource(Method method) {
		// 获取当前Method所在类的全限定名称
		String className = method.getDeclaringClass().getName();
		String methodName = method.getName();
		return className + ":" + methodName;
	}
    
    
}
