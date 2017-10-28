package com.sharelock;

public class Ceshi {
public static void main(String[] args) {
	Shareresoure sj=new Shareresoure();
	
	new Thread(new Producer(sj)).start();
	new Thread(new Consumer(sj)).start();
}
} 
