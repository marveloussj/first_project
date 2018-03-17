package xyz.marsj.ssh.mvc;


import org.springframework.beans.factory.annotation.Required;

import xyz.marsj.ssh.domain.Department;
import xyz.marsj.ssh.query.QueryObject;
import xyz.marsj.ssh.service.IDepartmentService;
import xyz.marsj.ssh.util.RequiredPermission;

public class DepartmentAction extends BaseAction {

	private IDepartmentService departmentService;
	private Department dept=new Department();
	private QueryObject queryObject=new QueryObject();
	
	
	public void setDepartmentService(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	@RequiredPermission("部门列表")
	public String execute(){
		this.addContext(PAGERESULT, this.departmentService.query(queryObject));
		return LIST;
	}
	@RequiredPermission("新增/编辑部门")
	public String input(){

		if(dept.getId()!=null){
			dept=this.departmentService.get(dept.getId());
		}
		return INPUT;
	}
	@RequiredPermission("修改部门")
	public String save(){
		if(dept.getId()!=null){
			this.departmentService.update(dept);
		}else{
			this.departmentService.save(dept);
		}
		return SUCCESS;
	}
	@RequiredPermission("删除部门")
	public String delete(){
		if(dept.getId()!=null){
			this.departmentService.delete(dept);
		}
		return SUCCESS;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department Dept) {
		this.dept = Dept;
	}
	public QueryObject getQueryObject() {
		return queryObject;
	}
	public void setQueryObject(QueryObject queryObject) {
		this.queryObject = queryObject;
	}
	



}

