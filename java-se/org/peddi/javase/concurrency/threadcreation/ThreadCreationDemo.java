package org.peddi.javase.concurrency.threadcreation;
import static java.lang.System.out;

public class ThreadCreationDemo {
	
	public void createTheardWithRunnable() {
		ThreadWithRunnable runnable = new ThreadWithRunnable();
		
		Thread t = new Thread(runnable, "ThreadWithRunnable");
		t.start();
		
		out.println( "createTheardWithRunnable" + "Name: " + t.getName()  + ", Id:  " + t.getId() + ", Priority: " + 
		t.getPriority() + ", State:" + t.getState() + ", ThreadGroup: " + t.getThreadGroup());
		
		
		
	}
	
	public void createThreadWithSubclass() {
		ThreadWithSubclass ts = new ThreadWithSubclass("ThreadWithSubclass");
		ts.start();
	}

	public static void main(String[] args) {
		
		ThreadCreationDemo app = new ThreadCreationDemo();
		System.out.println("Main Thread: " + Thread.currentThread() );
		out.println("ActiveCount in Main : " + Thread.activeCount() );
		app.createTheardWithRunnable();
		app.createThreadWithSubclass();
		
	}

}
