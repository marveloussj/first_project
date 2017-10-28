package com.xiancheng1;


class Appletwo implements Runnable{
	private int apple=100;

	public void run() {
		
		for (int i = 0; i < 100; i++) {
			synchronized(this)
			{
				if(apple>0)
			{
				System.out.println(Thread.currentThread().getName()+"吃了第 "+ apple-- + "个苹果");
			}

	try {
				Thread.sleep(10);
			} catch (Exception e) {
				// TODO: handle exception
			}
			}
		
	}
	
}
 
	
			
			


}
public class Synchronize1 {
	   public static void main(String[] args) {
			
			Appletwo sj=new Appletwo();
			new Thread (sj,"A").start();
			new Thread(sj,"B").start();
			new Thread(sj,"C").start();
		}
}
