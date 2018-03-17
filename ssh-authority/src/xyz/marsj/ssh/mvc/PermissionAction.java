package xyz.marsj.ssh.mvc;


import xyz.marsj.ssh.domain.Permission;
import xyz.marsj.ssh.query.QueryObject;
import xyz.marsj.ssh.service.IPermissionService;
import xyz.marsj.ssh.util.RequiredPermission;

public class PermissionAction extends BaseAction {

	private IPermissionService permissionService;
	private Permission permission=new Permission();
	private QueryObject queryObject=new QueryObject();
	@RequiredPermission("权限列表")
	public String execute(){
		System.out.println("execute");
		this.addContext(PAGERESULT, this.permissionService.query(queryObject));
		return LIST;
	}
	@RequiredPermission("删除权限")
	public String delete(){
		System.out.println("delete");
		if(permission.getId()!=null){
			this.permissionService.delete(permission);
		}
		return SUCCESS;
		
	}
	@RequiredPermission("重新加载权限")
	public String save() {
		this.permissionService.reload();
		return NONE;
	}
	

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public QueryObject getQueryObject() {
		return queryObject;
	}

	public void setQueryObject(QueryObject queryObject) {
		this.queryObject = queryObject;
	}

	public void setPermissionService(IPermissionService permissionService) {
		this.permissionService = permissionService;
	}

	



}

