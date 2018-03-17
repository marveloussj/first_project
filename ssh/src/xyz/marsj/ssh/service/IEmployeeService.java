package xyz.marsj.ssh.service;

import java.util.List;

import xyz.marsj.ssh.domain.Employee;

public interface IEmployeeService {
	void save(Employee e);
	void delete(Long id);
	Employee get(Long id);
	List<Employee> list();
}
