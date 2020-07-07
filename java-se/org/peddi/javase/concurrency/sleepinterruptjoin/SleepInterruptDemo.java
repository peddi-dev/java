package org.peddi.javase.concurrency.sleepinterruptjoin;

public class SleepInterruptDemo {
	
	public static void main(String[] args) {
		
		SleepUsage app = new SleepUsage();
		try {
			app.processMessages();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		InterruptUsage intApp = new InterruptUsage();
		intApp.process();
	}

}
