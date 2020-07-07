package org.peddi.javase.concurrency.guardedblock;

import java.util.Random;

public class Consumer implements Runnable {

	private MessageContainer container;
	Random tm = new Random();

	public Consumer(MessageContainer c) {
		this.container = c;
	}
	
	@Override
	public void run() {
		
		String msg = null;
		while(!Producer.END.equals(msg)) {
			
			msg =  getContainer().take();
			System.out.format("MESSAGE RECEIVED: %s %n", msg);
			try {
				Thread.sleep(tm.nextInt(5000));
			} catch (InterruptedException e) { }
		}
	}

	public MessageContainer getContainer() {
		return container;
	}
}
