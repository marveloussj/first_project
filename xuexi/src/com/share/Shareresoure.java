package com.share;

public class Shareresoure {
private String name;
private String gender;
private Boolean have=true;
synchronized public void shuru(String name,String gender){
	
	 	
	try {
		while(!have){
			this.wait();
		}
		this.name=name;
		Thread.sleep(10);
		this.gender=gender;
		this.notify();
		have=false;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


synchronized public void shuchu(){
	try {
		while(have){
			this.wait();
		}
		Thread.sleep(10);
		System.out.println(this.name+"-"+this.gender);
		this.notify();
		have=true;
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
