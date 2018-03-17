package xyz.marsj.spring.mvc;

public class EmployeeAction {
private IEmployeeService service;


public void setService(IEmployeeService service) {
	this.service = service;
}


public String save(){
	Employee e =new Employee();
	service.save(e);
	return "SUCCESS";
}
}
