package com.sharelock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shareresoure {
private String name;
private String gender;
private Boolean have=true;
private final Lock lock=new ReentrantLock();
private Condition cond= lock.newCondition();
 public void shuru(String name,String gender){
	
	 	
	try {
		lock.lock();
		while(!have){
			cond.await();
		}
		this.name=name;
		Thread.sleep(10);
		this.gender=gender;
		cond.signal();
		have=false;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		lock.unlock();
	}
}


 public void shuchu(){
	try {
		lock.lock();
		while(have){
			cond.await();
		}
		Thread.sleep(10);
		System.out.println(this.name+"-"+this.gender);
		cond.signal();
		have=true;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		lock.unlock();
	}
}

}
