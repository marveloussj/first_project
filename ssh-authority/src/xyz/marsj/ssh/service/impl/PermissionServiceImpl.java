package xyz.marsj.ssh.service.impl;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import xyz.marsj.ssh.dao.IPermissionDao;
import xyz.marsj.ssh.domain.Permission;
import xyz.marsj.ssh.mvc.BaseAction;
import xyz.marsj.ssh.query.PageResult;
import xyz.marsj.ssh.query.QueryObject;
import xyz.marsj.ssh.service.IPermissionService;
import xyz.marsj.ssh.util.PermissionUtil;
import xyz.marsj.ssh.util.RequiredPermission;

public class PermissionServiceImpl implements IPermissionService ,ApplicationContextAware{
	private IPermissionDao permissionDao;
	private ApplicationContext ctx;
	public void setPermissionDao(IPermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		this.ctx=ctx;
	}
	@Override
	public void delete(Permission o) {
		this.permissionDao.delete(o);
	}

	@Override
	public List<Permission> list() {
		return this.permissionDao.list();
	}

	@Override
	public PageResult query(QueryObject qo) {
		return this.permissionDao.query(qo);
	}

	@Override
	public void reload() {
		Map<String, BaseAction> map = ctx.getBeansOfType(BaseAction.class);
		for (Entry<String,BaseAction> entry: map.entrySet()) {
			Class<?> actionClass = entry.getValue().getClass();
			Method[] methods = actionClass.getDeclaredMethods(); 
			for (Method method : methods) {
				if(method.isAnnotationPresent(RequiredPermission.class)){
					RequiredPermission annotation = method.getAnnotation(RequiredPermission.class);
					Permission permission = new Permission();
					permission.setName(annotation.value());
					permission.setExpression(PermissionUtil.createExpression(method));
					this.permissionDao.save(permission);
				}
				
			}
		}
	}



}
