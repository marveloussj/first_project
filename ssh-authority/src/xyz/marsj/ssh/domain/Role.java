package xyz.marsj.ssh.domain;

import java.util.ArrayList;
import java.util.List;

public class Role extends BaseDomain{
	private String name;
	private String sn;
	private List<Permission> permission=new ArrayList<Permission>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public List<Permission> getPermission() {
		return permission;
	}
	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}
	

}
