package org.peddi.javase.concurrency.threadcreation;
import static java.lang.System.out;

public class ThreadWithRunnable implements Runnable {

	@Override
	public void run() {
		
		out.println("Thread: "+ Thread.currentThread()  +", ThreadLocal variable: " + ThreadLocalVariable.get());
		out.println("ThreadWithRunnable.run() ");
		out.println("Thread: " + Thread.currentThread() );
		out.println("ActiveCount in ThreadWithRunnable.run(): " + Thread.activeCount() );
		
		

		out.println("***end - ThreadWithRunnable");
		
	}
	
}
