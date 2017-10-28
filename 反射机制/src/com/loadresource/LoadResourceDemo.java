package com.loadresource;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoadResourceDemo {
public static void main(String[] args) throws Exception {
	 //方式1:使用绝对路径的方式加载
	//test1();
	//方式2:使用相对路径-相对于classpath的根路径（字节码输出目录）    主！
	//test2();
	test3();
	
	
}

private static void test3() throws Exception {
	Properties p=new Properties();
	InputStream inStream= LoadResourceDemo.class.getResourceAsStream("db.properties");
	p.load(inStream);
	System.out.println(p);
	
}

private static void test2() throws Exception {
	//方式2:使用相对路径-相对于classpath的根路径（字节码输出目录）
	Properties p =new Properties();
	//ClassLoader loader=LoadResourceDemo.class.getClassLoader();
	ClassLoader loader =Thread.currentThread().getContextClassLoader();
	InputStream inStream= loader.getResourceAsStream("db.properties");
	p.load(inStream);
	System.out.println(p);
	
}

private static void test1() throws Exception {
	 //方式1:使用绝对路径的方式加载
	Properties p=new Properties();
	InputStream inStream=new FileInputStream("C:/Users/Administrator/Desktop/work/反射机制/resources/db.properties");
	p.load(inStream);
	System.out.println(p);
}
}
