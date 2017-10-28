package com.xiancheng;
class Apple extends Thread{
	private static int  num = 50;//不加static 就不行

		public Apple(String name) {
		// TODO Auto-generated constructor stub
			super(name);
	}

		public void run() {
		
		for (int i = 0; i < 50; i++) {
			if(num>0)
			{
				System.out.println(super.getName()+"吃了第 "+ num-- + "个苹果");
			}
			
		}
	}
}


public class eatapple1 {
	
	
	
     public static void main(String[] args) {
		new Apple("A").start();
		new Apple("B").start();
		new Apple("C").start();
	}
}
