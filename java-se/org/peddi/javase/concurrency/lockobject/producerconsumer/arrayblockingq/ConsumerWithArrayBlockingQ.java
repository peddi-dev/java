package org.peddi.javase.concurrency.lockobject.producerconsumer.arrayblockingq;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class ConsumerWithArrayBlockingQ implements Runnable {
	ArrayBlockingQueue<String> buffer ;
	
	public ConsumerWithArrayBlockingQ(ArrayBlockingQueue<String> buffer) {
		this.buffer = buffer;
	}
	
	@Override
	public void run() {
		Random r = new Random();
		try {
			
			for(int i=0; i<5; i++) {
			
				String item = buffer.take();
				System.out.format("Take(): %s %n",item);
				r.nextInt(4000);
			}
		} catch (InterruptedException e) {
			
		}

	}

}
