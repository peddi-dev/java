package org.peddi.javase.concurrency.lockobject.safelock;

import java.util.Random;

public class SafeLockThread implements Runnable {
	
	private final FriendWIthLockObj bowee;
	private final FriendWIthLockObj bower;
	
	
	

	public SafeLockThread(FriendWIthLockObj bowee, FriendWIthLockObj bower) {
		super();
		this.bowee = bowee;
		this.bower = bower;
	}

	@Override
	public void run() {
		
		Random r = new Random();

		for(int i=0; i<5; i++) {
			
			bowee.bow(bower);
			try {
				Thread.sleep(r.nextInt(4000));
			} catch (InterruptedException e) {
				
			}
			
		}

	}

}
