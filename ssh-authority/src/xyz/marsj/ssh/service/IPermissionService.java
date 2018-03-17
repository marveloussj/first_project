package xyz.marsj.ssh.service;

import java.util.List;

import xyz.marsj.ssh.domain.Permission;
import xyz.marsj.ssh.query.PageResult;
import xyz.marsj.ssh.query.QueryObject;

public interface IPermissionService {
	void delete(Permission o);
	List<Permission> list();
	PageResult query(QueryObject qo);
	void reload();
}
