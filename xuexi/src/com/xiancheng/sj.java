package com.xiancheng;

import java.io.IOException;

public class sj {
	public static void main(String[] args) throws IOException {
		Runtime runtime= Runtime.getRuntime();
	runtime.exec("notepad");
	
	
	ProcessBuilder dage=new ProcessBuilder("notepad");
	dage.start();
	
	}
	
	
	
	
}
