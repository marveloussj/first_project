package xyz.marsj.ssh.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;

import xyz.marsj.ssh.dao.IEmployeeDao;
import xyz.marsj.ssh.dao.impl.EmployeeDaoImpl;
import xyz.marsj.ssh.domain.Employee;
import xyz.marsj.ssh.domain.Permission;
import xyz.marsj.ssh.domain.Role;
import xyz.marsj.ssh.query.PageResult;
import xyz.marsj.ssh.query.QueryObject;
import xyz.marsj.ssh.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDao employeeDao;
	public void setEmployeeDao(IEmployeeDao employeeDao) {
			this.employeeDao = employeeDao;
		}
	
	@Override
	public void save(Employee o) {
		employeeDao.save(o);
	}
	
	@Override
	public void update(Employee o) {
		employeeDao.update(o);
	}
	
	
	
	@Override
	public void delete(Employee o) {
		employeeDao.delete(o);
	}
	
	
	
	@Override
	public Employee get(Long id) {
		return employeeDao.get(id);
	}
	
	
	
	@Override
	public List<Employee> list() {
	
		return employeeDao.list();
	}
	
	
	
	@Override
	public PageResult query(QueryObject qo) {
		return employeeDao.query(qo);
	}

	@Override
	public Employee login(String userName, String password) {
		Employee emp=employeeDao.login(userName,password);
		if(emp!=null){
			ActionContext.getContext().getSession().put("USERINSESSION", emp);
			Set<String> permissions=new HashSet<String>();
			for(Role r:emp.getRoles()){
				for(Permission p:r.getPermission())
					permissions.add(p.getExpression());
			}
			ActionContext.getContext().getSession().put("PERMISSIONS", permissions);
		}
		return emp; 
	}

}
