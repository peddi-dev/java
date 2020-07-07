package org.peddi.javase.concurrency.sleepinterruptjoin;

import static java.lang.System.out;

public class SimpleThreadsExample {
	
	
	static void threadMessage(String msg) {
		
		out.format("%s: %s%n", Thread.currentThread().getName(), msg);
		
	}

	static class MessageLoop implements Runnable {
		
		String importantInfo[] = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
            };

		@Override
		public void run() {
		
			try {
				for( String m: importantInfo) {
					
					//sleep for 4 secs
					Thread.sleep(4000);
					
					//print a message 
					threadMessage(m);
					
				}
			}catch(InterruptedException e) {
				threadMessage("I was not finished yet.");
			}
			
		}
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		// Delay, in milliseconds before
        // we interrupt MessageLoop
        // thread (default one hour).
        long patience = 10000; //1000 * 60 * 60;
        
        threadMessage("Starting MessageLoop thread");
        long startTime = System.currentTimeMillis();
        Thread t = new Thread(new MessageLoop());
        t.start();
        
        threadMessage("Waiting for MessageLoop thread to finish");
        // loop until MessageLoop
        // thread exits
        while (t.isAlive()) {
            threadMessage("Still waiting...");
            // Wait maximum of 1 second
            // for MessageLoop thread
            // to finish.
            t.join(1000);
            if (((System.currentTimeMillis() - startTime) > patience)
                  && t.isAlive()) {
                threadMessage("Tired of waiting!");
                t.interrupt();
                // Shouldn't be long now
                // -- wait indefinitely
                t.join();
            }
        }
        threadMessage("Finally!");
	}
}
