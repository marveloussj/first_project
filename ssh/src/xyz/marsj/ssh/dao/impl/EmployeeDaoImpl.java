package xyz.marsj.ssh.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import xyz.marsj.ssh.dao.IEmployeeDao;
import xyz.marsj.ssh.domain.Employee;

public class EmployeeDaoImpl implements IEmployeeDao {
	private SessionFactory sessionFactory;
	

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void save(Employee e) {
		Session session = sessionFactory.getCurrentSession();
		session.save(e);
	}

	@Override
	public void delete(Long id) {
		Employee e=new Employee();
		e.setId(id);
		Session session = sessionFactory.getCurrentSession();
		session.delete(e);		
	}

	@Override
	public Employee get(Long id) {
		Session session = sessionFactory.getCurrentSession();
		return (Employee) session.get(Employee.class, id);
		 
	}

	@Override
	public List<Employee> list() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("SELECT e FROM Employee e").list();
	}

}
