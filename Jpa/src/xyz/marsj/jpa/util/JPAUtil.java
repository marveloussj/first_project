package xyz.marsj.jpa.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static final JPAUtil instance=new JPAUtil();
	//线程安全才能放这里
	private EntityManagerFactory managerFactory;
	private JPAUtil(){
	managerFactory = Persistence.createEntityManagerFactory("xyz.marsj.jpa");
	}
	public static JPAUtil getInstance(){
		return instance;
	}
	public EntityManager entityManager(){
		return managerFactory.createEntityManager();
	}
}
