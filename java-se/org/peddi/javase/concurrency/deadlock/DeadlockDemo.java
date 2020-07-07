package org.peddi.javase.concurrency.deadlock;
/**
 * Solution this deadlock with Lock object is available in the
 * org.peddi.javase.concurrency.lockobject.safelock.SafeLockDemo
 * @author peddi
 *
 */

public class DeadlockDemo {
	
	public static void main(String[] args) {
		
		System.out.println("Start");
		
		Deadlock d = new Deadlock();
		d.deadlock();
		
		System.out.println("End");
	}

}
