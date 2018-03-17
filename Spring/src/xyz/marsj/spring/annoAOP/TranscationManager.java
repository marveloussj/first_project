package xyz.marsj.spring.annoAOP;

import org.aspectj.lang.ProceedingJoinPoint;

public class TranscationManager {
	public void begin(){
		System.out.println("begin");
	}
	public void commit(){
		System.out.println("commit");
	}
	public void rollback(){
		System.out.println("rollback");
	}
	public void around(ProceedingJoinPoint pjp){
		try {
		    long startTime=System.currentTimeMillis();
		    pjp.proceed();
	        long endTime=System.currentTimeMillis();
	       float excTime=(float)(endTime-startTime)/1000;
	       System.out.println("执行时间："+excTime+"s");
		} catch (Throwable e) {
			System.out.println("after throwing");
		}finally {
			System.out.println("after");
		}
	}
}
