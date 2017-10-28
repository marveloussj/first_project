package com.method;

import java.lang.reflect.Method;
import java.util.Date;

class user{
	public void dowork(){
		System.out.println("dowork");
	}
	public void dowork(String name){
		System.out.println("name:"+name);
	}
	private void domanywork(String name,int age){
		System.out.println("name:"+name+"age:"+age);
	}
	
}
public class MethodDemo {
public static void main(String[] args) throws Exception {
	//getall();
	//getone();
	Object obj=new Date();
	Method m=obj.getClass().getMethod("toLocaleString");
	Object o= m.invoke(obj);
	System.out.println(o);
}

private static void getone() throws Exception {
	Class clz=user.class;
	Method m=clz.getMethod("dowork" );
	System.out.println(m);
	m=clz.getMethod("dowork", String.class);
	System.out.println(m);
	m=clz.getDeclaredMethod("domanywork",String.class,int.class);
	System.out.println(m);
}

private static void getall() {
	Class clz= user.class;
	Method[] m=clz.getMethods();
	System.out.println(m.length);
	for (Method me : m) {
		System.out.println(me);
	}
	m=clz.getDeclaredMethods();
	System.out.println(m.length);
	for (Method me : m) {
		System.out.println(me);
	}
	
}
}
