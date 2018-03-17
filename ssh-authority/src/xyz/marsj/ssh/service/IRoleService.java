package xyz.marsj.ssh.service;

import java.util.List;

import xyz.marsj.ssh.domain.Role;
import xyz.marsj.ssh.query.PageResult;
import xyz.marsj.ssh.query.QueryObject;

public interface IRoleService {
	void save(Role o);
	void update(Role o);
	void delete(Role o);
	Role get(Long id);
	List<Role> list();
	PageResult query(QueryObject qo);
}
