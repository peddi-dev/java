package org.peddi.javase.concurrency.lockobject.producerconsumer;

import java.util.Random;

public class Producer implements Runnable {
	
	BoundedBuffer<String> buffer ;
	
	public Producer(BoundedBuffer buffer) {
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
