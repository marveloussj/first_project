package xyz.marsj.ssh.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


public class Employee extends BaseDomain{
	
	private String userName;
	private String password;
	private String email;
	private Boolean admin;
	private Integer age;
	private Department dept;
	private List<Role> roles=new ArrayList<Role>();

	public String getRoleNames(){
		List<String> roleNames=new ArrayList<String>();
		for (Role role : roles) {
			roleNames.add(role.getName());
		}
		return StringUtils.join(roleNames,",");
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean isAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
}
