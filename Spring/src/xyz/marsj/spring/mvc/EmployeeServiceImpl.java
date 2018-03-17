package xyz.marsj.spring.mvc;

public class EmployeeServiceImpl implements IEmployeeService{

	private IEmployeeDao dao;

	public void setDao(IEmployeeDao dao) {
		this.dao = dao;
	}

	@Override
	public void save(Employee e) {
		System.out.println("做一些业务逻辑");
		dao.save(e);
	}

}
