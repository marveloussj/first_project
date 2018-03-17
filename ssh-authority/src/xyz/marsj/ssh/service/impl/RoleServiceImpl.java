package xyz.marsj.ssh.service.impl;

import java.util.List;

import xyz.marsj.ssh.dao.IRoleDao;
import xyz.marsj.ssh.domain.Role;
import xyz.marsj.ssh.query.PageResult;
import xyz.marsj.ssh.query.QueryObject;
import xyz.marsj.ssh.service.IRoleService;

public class RoleServiceImpl implements IRoleService{
	private IRoleDao roleDao;
	public void setRoleDao(IRoleDao roleDao) {
			this.roleDao = roleDao;
		}
	
	@Override
	public void save(Role o) {
		roleDao.save(o);
	}
	
	@Override
	public void update(Role o) {
		roleDao.update(o);
	}
	
	
	
	@Override
	public void delete(Role o) {
		roleDao.delete(o);
	}
	
	
	
	@Override
	public Role get(Long id) {
		return roleDao.get(id);
	}
	
	
	
	@Override
	public List<Role> list() {
	
		return roleDao.list();
	}
	
	@Override
	public PageResult query(QueryObject qo) {
		return roleDao.query(qo);
	}

}
