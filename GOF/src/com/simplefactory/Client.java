package com.simplefactory;

public class Client {
	public static void main(String[] args) {
		CreateCap cap1=new CapFactory().createBlueCap();
			cap1.run();
			CreateCap cap2 =new CapFactory().createRedCap();
			cap2.run();
	}
	
}
