package xyz.marsj.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import xyz.marsj.jpa.util.JPAUtil;





public class StudentDAOImpl implements IStudentDAO {

	@Override
	public void save(Student stu) {
		EntityManager manager = JPAUtil.getInstance().entityManager();
		manager.getTransaction().begin();
		manager.persist(stu);
		manager.getTransaction().commit();
		manager.close();
		
	}

	@Override
	public void delete(Long id) {
		EntityManager manager = JPAUtil.getInstance().entityManager();
		manager.getTransaction().begin();
		Student stu = manager.find(Student.class, id);
		manager.remove(stu);
		manager.getTransaction().commit();
		manager.close();
	}

	@Override
	public void update(Student stu) {
		EntityManager manager = JPAUtil.getInstance().entityManager();
		manager.getTransaction().begin();
		manager.merge(stu);
		manager.getTransaction().commit();
		manager.close();
		
	}

	@Override
	public Student get(Long id) {
		EntityManager manager = JPAUtil.getInstance().entityManager();
		manager.getTransaction().begin();
		Student find = manager.find(Student.class, id);
		manager.getTransaction().commit();
		manager.close();
		return find;
	}

	@Override
	public List<Student> query() {
		EntityManager manager = JPAUtil.getInstance().entityManager();
		manager.getTransaction().begin();
		List<Student> list = manager.createQuery("SELECT stu FROM Student stu", Student.class).getResultList();
		manager.getTransaction().commit();
		manager.close();
		return list;
	}


	

	

}
