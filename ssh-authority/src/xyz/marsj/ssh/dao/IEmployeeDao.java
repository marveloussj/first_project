package xyz.marsj.ssh.dao;

import xyz.marsj.ssh.domain.Employee;

public interface IEmployeeDao extends IGenericDao<Employee> {
	Employee login(String userName, String password);
}
