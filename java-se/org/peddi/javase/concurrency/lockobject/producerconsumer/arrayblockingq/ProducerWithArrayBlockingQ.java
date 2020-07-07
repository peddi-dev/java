package org.peddi.javase.concurrency.lockobject.producerconsumer.arrayblockingq;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ProducerWithArrayBlockingQ implements Runnable {
	
private ArrayBlockingQueue<String> buffer ;
	
	public ProducerWithArrayBlockingQ(ArrayBlockingQueue buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		for(int i=0; i<5; i++) {
			try {
				String item = "Message " + i;
				buffer.put(item );
				System.out.format("Put(): %s %n",item);
				Thread.sleep(r.nextInt(2000));
			} catch (InterruptedException e) {
				
			}
		}
	}

}
