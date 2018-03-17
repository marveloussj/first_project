package xyz.marsj.ssh.dao.impl;

import java.util.List;

import org.hibernate.Session;

import xyz.marsj.ssh.dao.IEmployeeDao;
import xyz.marsj.ssh.domain.Employee;

public class EmployeeDaoImpl extends GenericDaoImpl<Employee> implements IEmployeeDao {

	@Override
	public Employee login(String userName, String password) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Employee> list = session.createQuery("SELECT e FROM Employee e WHERE e.userName= ? AND e.password = ? ")
				.setParameter(0, userName).setParameter(1,password).list();
		if(list.size()==1){
			return list.get(0);
		}
		return null;
	}

}
