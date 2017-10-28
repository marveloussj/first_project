package com.sharelock;

public class Producer implements Runnable{
private Shareresoure resoure=null;

	public Producer(Shareresoure resoure) {
	super();
	this.resoure = resoure;
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 50; i++) {
			if(i%2==1)
				resoure.shuru("sj1", "ÄÐ");
			else
				resoure.shuru("mm1", "Å®");
		}
		
	}

	

}