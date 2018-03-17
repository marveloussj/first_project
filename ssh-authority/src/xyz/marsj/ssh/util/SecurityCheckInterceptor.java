package xyz.marsj.ssh.util;

import java.lang.reflect.Method;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import xyz.marsj.ssh.domain.Employee;
import xyz.marsj.ssh.mvc.BaseAction;

public class SecurityCheckInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Employee emp =(Employee) ActionContext.getContext().getSession().get("USERINSESSION");
		if(emp.isAdmin()){
			return invocation.invoke();
		}else{
			Class<?> targetClass = invocation.getProxy().getAction().getClass();
			String methodName = invocation.getProxy().getMethod();
			Method method = targetClass.getMethod(methodName, null);
			if(method!=null&& method.isAnnotationPresent(RequiredPermission.class)){
				String expression = PermissionUtil.createExpression(method);
				Set<String> set=(Set<String>) ActionContext.getContext().getSession().get("PERMISSIONS");
				if(set!=null &&	set.contains(expression)){
					return invocation.invoke();
				}
			}else{
				return invocation.invoke(); 
			}
		}
		return BaseAction.NOPERMISSION;
	}

}
