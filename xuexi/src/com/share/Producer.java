package com.share;

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
				resoure.shuru("sj", "ÄÐ");
			else
				resoure.shuru("mm", "Å®");
		}
		
	}

	

}