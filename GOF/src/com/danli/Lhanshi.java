package com.danli;
/**
 * 懒汉式
 * 调用效率低，可以延时加载
 * @author sj
 *
 */
public class Lhanshi {
	private static Lhanshi instance=null;
	private Lhanshi() {
		// TODO Auto-generated constructor stub
	}
	public static Lhanshi getinstance(){
		if(instance==null){
			instance=new Lhanshi();
		}
		return instance;
	}
}
