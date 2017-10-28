package com.constructor;

import java.lang.reflect.Constructor;

class person{
	public person(){
		System.out.println("无参构造器");
	}
	public person(String name){
		System.out.println("name:"+name);
	}
	private person(String name, int age){
		System.out.println("name:"+name+"age:"+age);
	}
}
public class ConstructorDemo {
public static void main(String[] args) throws Exception {
	//调用无参构造
	Class<person> clz=person.class;
	Constructor<person> con= clz.getConstructor();
	con.newInstance();
	//老方法
	//new person();
	//调用第二个构造器
	Class<person> clz1=person.class;
	Constructor<person> con1=clz1.getConstructor(String.class);
	con1.newInstance("sj");
	//调用第三个构造器
	Class<person> clz2=person.class;
	//访问private的时候，不要忘记加上Declared
	Constructor<person> con2=clz2.getDeclaredConstructor(String.class,int.class);
	con2.setAccessible(true);
	con2.newInstance("sj",20);
	
	
}
}
