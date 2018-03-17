package xyz.marsj.spring.annoAOP;

public class EmployeeDaoIpml implements IEmployeeDao {

	@Override
	public void list(Employee e) {
		int x=0;
		for (int i = 0; i <1000; i++) {
			x++;
		}
		System.out.println("e.list()"+x);
	}

	@Override
	public void query(Employee e) {
		int x=0;
		for (int i = 0; i <2000000; i++) {
			x=i*i;
		}
		System.out.println("e.query()"+x);
	}

}
