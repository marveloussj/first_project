package xyz.marsj.ssh.dao;

import java.util.List;

import xyz.marsj.ssh.domain.Employee;

public interface IEmployeeDao {
	void save(Employee e);
	void delete(Long id);
	Employee get(Long id);
	List<Employee> list();
}
