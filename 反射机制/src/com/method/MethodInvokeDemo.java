package com.method;

import java.lang.reflect.Method;

class user1{
		public void dowork(){
			System.out.println("dowork");
		}
		public void dowork(String name){
			System.out.println("name:"+name);
		}
		private String domanywork(String name,int age){
			System.out.println("name:"+name+"age:"+age);
			return name+age;
		}
		}
public class MethodInvokeDemo {

public static void main(String[] args) throws Exception {
	Class clz=user1.class;
	Method m =clz.getMethod("dowork");
	m.invoke(clz.newInstance());
	
	m=clz.getMethod("dowork", String.class);
	m.invoke(clz.newInstance(), "sj");
	//declared 
	m=clz.getDeclaredMethod("domanywork", String.class,int.class);
	//setaccessible
	m.setAccessible(true);
	Object ret=m.invoke(clz.newInstance(), "sj",20);
	System.out.println(ret);
	
	
	
	
	
	
	Class claz= user1.class;
	 Method ss= claz.getMethod("dowork");
	 ss.invoke(claz.newInstance());
	
	 
	 Class clzz=user1.class;
	 
	 Method method= clzz.getDeclaredMethod("domanywork", String.class,int.class);
	 method.setAccessible(true);
	 method.invoke(clzz.newInstance(), "dage",19);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	

		
	
}
