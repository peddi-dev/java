package org.peddi.javase.concurrency.sleepinterruptjoin;

public class SleepUsage {
	private String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };
	
	public void processMessages() throws InterruptedException {
		
		System.out.println("\n SleepUsage.process()");
		
		for(String msg: importantInfo) {
			System.out.println(msg);
			Thread.sleep(1000);
		}
	}

}
