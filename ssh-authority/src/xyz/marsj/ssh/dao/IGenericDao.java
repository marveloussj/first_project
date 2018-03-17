package xyz.marsj.ssh.dao;

import java.util.List;

import xyz.marsj.ssh.domain.Employee;
import xyz.marsj.ssh.query.PageResult;
import xyz.marsj.ssh.query.QueryObject;

public interface IGenericDao<T> {
	void save(T o);
	void update(T o);
	void delete(T o);
	T get(Long id);
	List<T> list();
	PageResult query(QueryObject qo);
}
