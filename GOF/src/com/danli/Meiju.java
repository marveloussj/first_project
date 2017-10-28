package com.danli;
/**
 * 枚举类enum
 * @author sj
 * 不能延时加载
 *枚举类好于饿汉式   不需要延时加载
 *静态内部类好于懒汉式  要延时加载
 */
public enum Meiju {
	instance;

	
	public void todo(){
		System.out.println(instance);
	}
}
