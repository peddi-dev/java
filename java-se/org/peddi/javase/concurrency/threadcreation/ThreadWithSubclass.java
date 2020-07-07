package org.peddi.javase.concurrency.threadcreation;

import static java.lang.System.out;

public class ThreadWithSubclass extends Thread {	

	public ThreadWithSubclass(String name) {
		
		super(name);
		
	}

	@Override
	public void run() {
		
		super.run();
		System.out.println("ThreadWithSubclass.run() ");
		out.println("Thread: " + Thread.currentThread() );
		out.println("ActiveCount in ThreadWithSubclass.rum(): " + Thread.activeCount() );
		
		out.println("Thread: "+ Thread.currentThread()  +", ThreadLocal variable: " + ThreadLocalVariable.get());
		out.println("***end - ThreadWithSubclass");
	}
}
