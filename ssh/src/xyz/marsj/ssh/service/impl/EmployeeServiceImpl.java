package xyz.marsj.ssh.service.impl;

import java.util.List;

import xyz.marsj.ssh.dao.IEmployeeDao;
import xyz.marsj.ssh.dao.impl.EmployeeDaoImpl;
import xyz.marsj.ssh.domain.Employee;
import xyz.marsj.ssh.service.IEmployeeService;

public class EmployeeServiceImpl implements IEmployeeService {
	private IEmployeeDao employeeDao;
	

	
public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public void save(Employee e) {
		employeeDao.save(e);
	}

	@Override
	public void delete(Long id) {
		
		employeeDao.delete(id);
	}

	@Override
	public Employee get(Long id) {
		
		return employeeDao.get(id);
	}

	@Override
	public List<Employee> list() {
		
		return employeeDao.list();
	}

}
