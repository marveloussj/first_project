package com.xiancheng1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Applethree implements Runnable{
	private int apple=100;
private final Lock lock=new ReentrantLock();
	public void run() {
		
		for (int i = 0; i < 100; i++) {
			eat();
		}
	}
	private void eat()
	{
		lock.lock();
try {
		if(apple>0)
	{
		System.out.println(Thread.currentThread().getName()+"吃了第 "+ apple-- + "个苹果");
	}
		Thread.sleep(10);
	} catch (Exception e) {
		// TODO: handle exception
	}finally{
		lock.unlock();
	}
	 
	}
	
}
 
	
			
			



public class Locksuo {
	   public static void main(String[] args) {
			
			Applethree sj=new Applethree();
			new Thread (sj,"A").start();
			new Thread(sj,"B").start();
			new Thread(sj,"C").start();
		}
}