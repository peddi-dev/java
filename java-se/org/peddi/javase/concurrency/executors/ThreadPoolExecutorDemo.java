package org.peddi.javase.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import static java.lang.System.out;

public class ThreadPoolExecutorDemo {
	
	public void newFixedThreadPoolDemo() {
		
		ThreadPoolExecutor   threadPool1, threadPool2;
		
		threadPool1 = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		threadPool2 = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
		
		// output is 0, because thread will be created when the tasks are submitted 
		out.format("%n%s", threadPool1.getTaskCount() );
		out.format("%n%s", threadPool2.getTaskCount() );
		
	}
	
	public void newSingleThreadExecutorDemo() {
		
		ExecutorService executor = Executors.newSingleThreadExecutor(); 
		out.format("%n%s", executor.getClass() );
		
	}

	public static void main(String[] args) {
		ThreadPoolExecutorDemo app = new ThreadPoolExecutorDemo();
		app.newFixedThreadPoolDemo();
		app.newSingleThreadExecutorDemo();

	}

}
