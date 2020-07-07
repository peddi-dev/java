package org.peddi.javase.concurrency.guardedblock;

import java.util.Random;

public class Producer implements Runnable {
	
	private MessageContainer container;
	private String[] data =  { 
			"Message 1 ", "Message 2", "Message 3"
	};
	public static final String END = "END";
	Random tm = new Random();
	
	public Producer(MessageContainer c) {
		this.container = c;
	}
	
	@Override
	public void run() {
		
		for(String msg: data) {
			
			getContainer().put(msg);
			try {
				Thread.sleep(tm.nextInt(5000));
			} catch (InterruptedException e) { }
			
		}
		getContainer().put(END);
	}

	public MessageContainer getContainer() {
		return container;
	}
}
