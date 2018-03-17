package xyz.marsj.ssh.mvc;


import xyz.marsj.ssh.domain.Employee;
import xyz.marsj.ssh.query.EmployeeQueryObject;
import xyz.marsj.ssh.service.IDepartmentService;
import xyz.marsj.ssh.service.IEmployeeService;
import xyz.marsj.ssh.service.IRoleService;
import xyz.marsj.ssh.util.RequiredPermission;

public class EmployeeAction extends BaseAction {
	private IDepartmentService departmentService;
	private IRoleService roleService;
	private IEmployeeService employeeService;
	private Employee employee=new Employee();
	private EmployeeQueryObject queryObject=new EmployeeQueryObject();
	
	
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	@RequiredPermission("员工列表")
	public String execute(){
		this.addContext("depts", this.departmentService.list());
		this.addContext(PAGERESULT, this.employeeService.query(queryObject));
		return LIST;
	}
	@RequiredPermission("新增/编辑员工")
	public String input(){
		this.addContext("roles", this.roleService.list());
		this.addContext("depts", this.departmentService.list());
		if(employee.getId()!=null){
			employee=this.employeeService.get(employee.getId());
		}
		return INPUT;
	}
	public void prepareSave(){
		if(employee.getId()!=null){
		 employee = this.employeeService.get(employee.getId());
		 employee.setDept(null);
		}
		employee.getRoles().clear();
	}
	@RequiredPermission("修改员工")
	public String save(){
		if(employee.getId()!=null){
			this.employeeService.update(employee);
		}else{
			this.employeeService.save(employee);
		}
		return SUCCESS;
	}
	@RequiredPermission("删除员工")
	public String delete(){
		if(employee.getId()!=null){
			this.employeeService.delete(employee);
		}
		return SUCCESS;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public EmployeeQueryObject getQueryObject() {
		return queryObject;
	}
	public void setQueryObject(EmployeeQueryObject queryObject) {
		this.queryObject = queryObject;
	}
	



}
