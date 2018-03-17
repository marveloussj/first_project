package xyz.marsj.ssh.util;

import java.lang.reflect.Method;

import xyz.marsj.ssh.mvc.EmployeeAction;

public class PermissionUtil {
	public static final String createExpression(Method m){
		StringBuilder sb=new StringBuilder(100).append(m.getDeclaringClass().getName()).append(":")
				.append(m.getName());
		return sb.toString();
	}
/*	public static void main(String[] args) {
		Class<?> clz=EmployeeAction.class;
		Method[] m=clz.getDeclaredMethods();
		for (Method method : m) {
			System.out.println(createExpression(method));
		}
	}*/
}
