package xyz.marsj.ssh.service;

import java.util.List;

import xyz.marsj.ssh.domain.Employee;
import xyz.marsj.ssh.query.PageResult;
import xyz.marsj.ssh.query.QueryObject;

public interface IEmployeeService {
	void save(Employee o);
	void update(Employee o);
	void delete(Employee o);
	Employee get(Long id);
	List<Employee> list();
	PageResult query(QueryObject qo);
	Employee login(String userName, String password);
}
