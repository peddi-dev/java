package org.peddi.javase.concurrency.exercise;

/**
 *  Question: How to ensure print() statement in main() always
 *  prints the message from the thread.
 *  
 * @author peddi
 *
 */
public class BadThread {
	static String message;

    private static class CorrectorThread
        extends Thread {

        public void run() {
            try {
                sleep(1000); 
            } catch (InterruptedException e) {}
            // Key statement 1:
            message = "T-Mares do eat oats."; 
        }
    }

    public static void main(String args[])
        throws InterruptedException {

       Thread t =  (new CorrectorThread());
       t.start();
        message = "Mares do NOT eat oats.";
        Thread.sleep(2000);
        //Solution
        t.join();
        // Key statement 2:
        System.out.println(message);
    }
}
