package com.xiancheng;
 class fhs extends java.lang.Thread{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<50;i++)
			{
				System.out.println("j"+i);
			}
			super.run();
		}
	}
public class threadsj { 

	
	
	
	public static void main(String[] args)
	{
			for(int i=0;i<50;i++)
		{
			System.out.println("s"+i);
			if(i==10){
				fhs t = new fhs();
				t.start();
				
			}
		}
		
	}
		
	
		
		
	
}
