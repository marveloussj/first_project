package xyz.marsj.ssh.service;

import java.util.List;

import xyz.marsj.ssh.domain.Department;
import xyz.marsj.ssh.query.PageResult;
import xyz.marsj.ssh.query.QueryObject;

public interface IDepartmentService {
	void save(Department o);
	void update(Department o);
	void delete(Department o);
	Department get(Long id);
	List<Department> list();
	PageResult query(QueryObject qo);
}
