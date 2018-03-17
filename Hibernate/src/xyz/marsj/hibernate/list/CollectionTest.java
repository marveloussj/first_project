package xyz.marsj.hibernate.list;

import org.hibernate.Session;
import org.junit.Test;

import xyz.marsj.hibernate.util.HibernateUtil;

public class CollectionTest {
@Test
public void testSave(){
	Employee emp=new Employee();
	emp.setName("sj");
	
	Employee emp1=new Employee();
	emp1.setName("sj1");
	
	Department d=new Department();
	d.setName("daxue");
	Session session = HibernateUtil.getInstance().openSession();
	session.beginTransaction();
	session.save(d);
	session.save(emp);
	session.save(emp1);
	session.getTransaction().commit();
	session.close();
}
}
