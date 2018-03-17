package xyz.marsj.ssh.service.impl;

import java.util.List;

import xyz.marsj.ssh.dao.IDepartmentDao;
import xyz.marsj.ssh.domain.Department;
import xyz.marsj.ssh.query.PageResult;
import xyz.marsj.ssh.query.QueryObject;
import xyz.marsj.ssh.service.IDepartmentService;

public class DepartmentServiceImpl implements IDepartmentService {
	private IDepartmentDao departmentDao;
	public void setDepartmentDao(IDepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	@Override
	public void save(Department o) {
		departmentDao.save(o);

	}

	@Override
	public void update(Department o) {
		departmentDao.update(o);

	}

	@Override
	public void delete(Department o) {
		departmentDao.delete(o);

	}

	@Override
	public Department get(Long id) {
		
		return departmentDao.get(id);
	}

	@Override
	public List<Department> list() {
		
		return departmentDao.list();
	}

	@Override
	public PageResult query(QueryObject qo) {
		
		return departmentDao.query(qo);
	}

}
