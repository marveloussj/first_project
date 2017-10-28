package com.danli;

import java.lang.reflect.Constructor;

public class Client {
   
     public static void main(String[] args) throws Exception {
    	  Lhanshi s1=Lhanshi.getinstance();
    	  Lhanshi s2=Lhanshi.getinstance();
    	  System.out.println(s1);
    	  System.out.println(s2);
    	  
    	  Singleton a1= Singleton.getinstance();
    	  Singleton a2= Singleton.getinstance();
    	  System.out.println(a1);
    	  System.out.println(a2);
    	  System.out.println("----------------------------------------");
    	  //枚举
    	System.out.println( Meiju.instance);
    	System.out.println( Meiju.instance);
    	  
    	  System.out.println("----------------------------------------");
    	  //使用反射获取构造器，破坏单例
    	  Class clz =Singleton.class;
    	  Constructor c= clz.getDeclaredConstructor();
    	  c.setAccessible(true);
    	  System.out.println(c.newInstance());
    	  System.out.println(c.newInstance());
    	  //作业 使用反序列化的方式，破坏单例
    	  
    	  
	}
}
