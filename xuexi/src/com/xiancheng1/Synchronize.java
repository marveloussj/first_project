package com.xiancheng1;


class Appleone implements Runnable{
	private int apple=100;

	public void run() {
		
		for (int i = 0; i < 100; i++) {
			
			eat();
	}
	
}
 synchronized private void eat()
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
public class Synchronize {
	   public static void main(String[] args) {
			
			Appleone sj=new Appleone();
			new Thread (sj,"A").start();
			new Thread(sj,"B").start();
			new Thread(sj,"C").start();
		}
}
