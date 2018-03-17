package xyz.marsj.struct2.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("拦截—"+invocation.getProxy().getActionName());
		Object user = invocation.getInvocationContext().getSession().get("USER_IN_SESSION");
		if(user==null){
			return Action.LOGIN;
		}
		return invocation.invoke();
	}



}
