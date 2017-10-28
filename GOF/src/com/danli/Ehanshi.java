package com.danli;
/**
 * 饿汉式
 * 调用效率高，不能延时加载
 * @author sj
 *
 */
public class Ehanshi {
	private static Ehanshi instance=new Ehanshi();
	private Ehanshi() {
		}
	public static Ehanshi getinstance(){
		return Ehanshi.instance;
	}

}
