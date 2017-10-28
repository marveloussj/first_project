package com.danli;
/**
 * 静态内部类 
 * 调用效率高，延时加载
 * @author sj
 *
 */
public class Singleton {
	private static class siglentonclass{
		private static Singleton instance=new Singleton();
	}
	public static Singleton getinstance(){
		
		return siglentonclass.instance;
	}
	
	
	private Singleton() {
		// 防止反射破坏单例
		if(siglentonclass.instance !=null){
		//	throw new RuntimeException();
			System.out.println("不行");
		}
	}

}
