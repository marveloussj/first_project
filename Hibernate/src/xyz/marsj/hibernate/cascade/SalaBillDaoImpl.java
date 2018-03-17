package xyz.marsj.hibernate.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import xyz.marsj.hibernate.util.HibernateUtil;

public class SalaBillDaoImpl implements SalaBillDao {

	@Override
	public void save(SalaBill bill) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		session.save(bill);
		session.getTransaction().commit();
		session.close();

	}

	
	public void update2(SalaBill bill) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		
		session.update(bill);
		session.getTransaction().commit();
		session.close();

	}
	@Override
	public void update(SalaBill bill) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		SalaBill oldBill = (SalaBill)session.get(SalaBill.class, bill.getId());
		List<SalaBillItem> deletes=new ArrayList<SalaBillItem>();
		for(SalaBillItem item:oldBill.getSbi()){
			boolean find=false;
			for(SalaBillItem newItem:bill.getSbi()){
				if(bill.getId()!=null&&item.getId().equals(newItem.getId())){
					find=true;
				}
			}
			if(!find){
				deletes.add(item);
			}
		}
		
		oldBill.getSbi().removeAll(deletes);
		for(SalaBillItem item:deletes){
			item.setBill(null);
		}
		session.update(oldBill);
		session.getTransaction().commit();
		session.close();

	}
	
	@Override
	public void delete(Long id) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		SalaBill bill = (SalaBill)session.get(SalaBill.class, id);
		session.delete(bill);
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public SalaBill get(Long id) {
		Session session = HibernateUtil.getInstance().openSession();
		session.beginTransaction();
		SalaBill bill = (SalaBill)session.get(SalaBill.class, id);
		Hibernate.initialize(bill.getSbi());
		session.getTransaction().commit();
		session.close();
		return bill;

	}

}
