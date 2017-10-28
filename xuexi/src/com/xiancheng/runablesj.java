package com.xiancheng;

class runablej implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<50;i++)
		{
			System.out.println("j"+i);
		}
	}
	
}



public class runablesj {
	
	public static void main(String[] args) {
		for(int i=0;i<50;i++)
	{
		System.out.println("s"+i);
		if(i==10){
			runablej sj=new runablej();
			Thread t=new Thread(sj);
			t.start();
		
		}
}

	}
	
	
}
	