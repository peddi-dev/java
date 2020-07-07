package org.peddi.javase.concurrency.lockobject.producerconsumer;

import java.util.Random;

public class Consumer implements Runnable {
	private BoundedBuffer<String> buffer;
	
	public Consumer(BoundedBuffer buffer) {
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
