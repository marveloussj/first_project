package xyz.marsj.ssh.mvc;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import xyz.marsj.ssh.service.IEmployeeService;

public class EmployeeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private IEmployeeService employeeService;
	
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public String list(){
		ActionContext.getContext().put("es",employeeService.list());
		return "list";
	}

}
