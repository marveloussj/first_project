package xyz.marsj.ssh.mvc;


import xyz.marsj.ssh.domain.Role;
import xyz.marsj.ssh.query.QueryObject;
import xyz.marsj.ssh.service.IPermissionService;
import xyz.marsj.ssh.service.IRoleService;
import xyz.marsj.ssh.util.RequiredPermission;

public class RoleAction extends BaseAction {
	private IRoleService roleService;
	private IPermissionService permissionService;
	private Role role=new Role();
	private QueryObject queryObject=new QueryObject();
	

	public void setPermissionService(IPermissionService permissionService) {
		this.permissionService = permissionService;
	}
	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}
	@RequiredPermission("角色列表")
	public String execute(){
		this.addContext(PAGERESULT, this.roleService.query(queryObject));
		return LIST;
	}
	@RequiredPermission("新增/编辑角色")
	public String input(){
		this.addContext("permissions",this.permissionService.list());
		if(role.getId()!=null){
			role=this.roleService.get(role.getId());
		}
		return INPUT;
	}
	public void prepareSave(){
		if(role.getId()!=null){
		 role = this.roleService.get(role.getId());
		}
		role.getPermission().clear();
	}
	@RequiredPermission("修改角色")
	public String save(){
		if(role.getId()!=null){
			this.roleService.update(role);
		}else{
			this.roleService.save(role);
		}
		return SUCCESS;
	}
	@RequiredPermission("删除角色")
	public String delete(){
		if(role.getId()!=null){
			this.roleService.delete(role);
		}
		return SUCCESS;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role Role) {
		this.role = Role;
	}
	public QueryObject getQueryObject() {
		return queryObject;
	}
	public void setQueryObject(QueryObject queryObject) {
		this.queryObject = queryObject;
	}
	



}
