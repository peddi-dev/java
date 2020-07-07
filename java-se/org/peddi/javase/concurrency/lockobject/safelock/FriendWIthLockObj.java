package org.peddi.javase.concurrency.lockobject.safelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import static java.lang.System.out;
public class FriendWIthLockObj {
	private final String name;
	private final Lock lock = new ReentrantLock();
	
	public FriendWIthLockObj(String n) {
		this.name = n;
	}
	
	private boolean impendingBow(FriendWIthLockObj bower) {
		
		boolean myLock = false; 
		boolean yourLock = false;
		
		boolean result = false;
		
		try {
			myLock = this.getLock().tryLock();
			yourLock = bower.getLock().tryLock();
			
			result = myLock & yourLock;
			
		}finally {
			if(!result ) {
				if(myLock) {
					this.getLock().unlock();
				}
				if(yourLock) {
					bower.getLock().unlock();
				}
			}
		}
		
		return result;
	}
	
	public void bow(FriendWIthLockObj bower) {
		
		if( impendingBow(bower) ) {
			
			try {
				out.format("%s: %s has bowed to me.%n", this.getName(), bower.getName());
				bower.bowBack(this);
				
			}finally {
				this.getLock().unlock();
				bower.getLock().unlock();
			}
			
		}else {
			out.format("%s: %s has tried to bow me, but saw that I am already bowing to him. %n", 
					
					this.getName(), bower.getName());
		}
		
	}
	
	public void bowBack(FriendWIthLockObj bower) {
		
		out.format("%s: %s has bowed Back to me.%n", this.getName(), bower.getName());
		
	}

	public String getName() {
		return name;
	}

	public Lock getLock() {
		return lock;
	}

}
