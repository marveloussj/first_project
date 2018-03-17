package xyz.marsj.spring.annoAOP;

public class DepartmentDaoIpml implements IDepartmentDao {

	@Override
	public void list(Department d) {
		int x=0;
		for (int i = 0; i <1000; i++) {
			x++;
		}
		System.out.println("d.list()"+x);
	}

	@Override
	public void query(Department d) {
		int x=0;
		for (int i = 0; i <2000000; i++) {
			x=i*i;
		}
		System.out.println("d.query()"+x);
	}

}
