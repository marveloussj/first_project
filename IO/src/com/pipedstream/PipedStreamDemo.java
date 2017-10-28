package com.pipedstream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class AThread extends Thread{
	private PipedOutputStream out= new PipedOutputStream();
	public PipedOutputStream getOut() {
		return out;
	}
	public void run() {
		try {
	 for (int i = 65; i < 65+26; i++) {
			out.write(i);
		} 
	 out.close();
	 } catch (IOException e) {
			
			e.printStackTrace();
		
		}
	}
}
class BThread extends Thread{
	 PipedInputStream in =null;
	 public BThread(AThread a) throws Exception {
		in= new PipedInputStream (a.getOut());
		
	}
	public void run() {
		int len=-1;
			try {
				while((len=in.read())!=-1){
				System.out.println((char)len);
}
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		
	}
	
	
}

public class PipedStreamDemo {
	public static void main(String[] args) throws Exception {
		AThread a=new AThread();
		BThread b=new BThread(a);
		a.start();
		b.start();
		
	}

}
