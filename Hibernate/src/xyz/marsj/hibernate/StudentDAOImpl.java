package xyz.marsj.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import xyz.marsj.hibernate.util.HibernateUtil;



public class StudentDAOImpl implements IStudentDAO {

	public void save(Student stu) {
		Session session=HibernateUtil.getInstance().openSession();
		//开启事务
		Transaction transaction = session.beginTransaction();
		//保存
		session.save(stu);
		transaction.commit();
		session.close();
		
	}

	public void delete(Long id) {
		Student stu=new Student();
		stu.setId(id);
		Session session = HibernateUtil.getInstance().openSession();
		Transaction transaction = session.beginTransaction();
		session.delete(stu);
		transaction.commit();
		session.close();
	}

	public void update(Student stu) {
		Session session=HibernateUtil.getInstance().openSession();
		Transaction transaction = session.beginTransaction();
		session.update(stu);
		transaction.commit();
		session.close();
		
	}

	@Override
	public Student get(Long id) {
		Session session = HibernateUtil.getInstance().openSession();
	 Student stu=(Student)session.get(Student.class, id);
		session.close();
		return stu;
	}
	@Override
	public List<Student> query() {
		Session session =HibernateUtil.getInstance().openSession();
		Query query = session.createQuery("SELECT stu FROM Student stu");
		List list = query.list();
		session.close();
		return list;
		
	}

	

	

}
