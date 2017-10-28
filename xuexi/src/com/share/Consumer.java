package com.share;

public class Consumer implements Runnable{
private Shareresoure re=null;

	public Consumer(Shareresoure re) {
	super();
	this.re = re;
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i <50; i++) {
			re.shuchu();
		}
		 	
	}

}
