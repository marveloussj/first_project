package xyz.marsj.struct2.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String execute() throws Exception {
		System.out.println("登录对象"+user);
		ActionContext.getContext().getSession().put("USER_IN_SESSION", user);
		return SUCCESS;
	}
	
	public String input() throws Exception {
		return LOGIN;
	}
}
