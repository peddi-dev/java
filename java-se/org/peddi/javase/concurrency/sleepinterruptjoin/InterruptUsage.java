package org.peddi.javase.concurrency.sleepinterruptjoin;

public class InterruptUsage {
	
	private String importantInfo[] = {
            "Mares eat oats",
            "Does eat oats",
            "Little lambs eat ivy",
            "A kid will eat ivy too"
        };
	
	public void process() {
		
		System.out.println("\n InterruptUsage.process()");
		
		for(String msg: importantInfo) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				return;
			}
			
			System.out.println(msg);
		}
		
	}

}
