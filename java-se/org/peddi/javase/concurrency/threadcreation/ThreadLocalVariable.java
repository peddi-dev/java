package org.peddi.javase.concurrency.threadcreation;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalVariable {
	
	// Atomic integer containing the next thread ID to be assigned
	private static final AtomicInteger nextId = new AtomicInteger(0);
	
	//Thread local variable containing each thread ID
	private static final ThreadLocal<Integer> threadId = new ThreadLocal<>() {
		
		@Override
		protected Integer initialValue() {
			
			return nextId.getAndIncrement();
			
		}
	};
	
	
	public static int get() {
		return threadId.get();
	}
	

}
