package xyz.marsj.hibernate.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private static final HibernateUtil instance=new HibernateUtil();
	//线程安全才能放这里
	private SessionFactory sessionFactory;
	private HibernateUtil(){
	Configuration conf = new Configuration().configure();
	//sessionFactory =conf.buildSessionFactory(new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry());
	sessionFactory = conf.buildSessionFactory();
	}
	public static HibernateUtil getInstance(){
		return instance;
	}
	public Session openSession(){
		return sessionFactory.openSession();
	}
}
