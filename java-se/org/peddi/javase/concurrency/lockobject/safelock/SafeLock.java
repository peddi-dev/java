package org.peddi.javase.concurrency.lockobject.safelock;

public class SafeLock {
	
	public void safeLock() {
		
		FriendWIthLockObj alphones = new FriendWIthLockObj("Alphones");
		FriendWIthLockObj gorton = new FriendWIthLockObj("Gorton");
		
		SafeLockThread st1 = new SafeLockThread(alphones, gorton);
		SafeLockThread st2 = new SafeLockThread(gorton, alphones);
		
		Thread t1 = new Thread(st1, "Alphones");
		Thread t2 = new Thread(st2, "Gorton");
		
		t1.start();
		t2.start();
	}

}
