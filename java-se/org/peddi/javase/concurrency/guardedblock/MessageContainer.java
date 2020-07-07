package org.peddi.javase.concurrency.guardedblock;

public class MessageContainer {
	
	private String message;
	
	public synchronized void put(String msg) {
		
		/**
		 * wait for the message to be read
		 */
		while(null != getMessage() ) {
			
			try {
				wait();
			} catch (InterruptedException e) { }	
		}
	
		/**
		 * write the message
		 */
		setMessage(msg);
		/**
		 * notify the consumer that the message is available
		 */
		notifyAll();
		
	}
	
	public synchronized String take() {
		
		
		/**
		 * wait for the message to be available
		 */
		while(null == getMessage()) {
			try {
				wait();
			} catch (InterruptedException e) { }
			
		}
		
		/**
		 * read the message
		 */
		String result = getMessage();
		setMessage(null);
		
		/**
		 * notify the producer the message is read
		 */
		notifyAll();
		
		return result;
	}
	
	private String getMessage() {
		return message;
	}

	private void setMessage(String message) {
		this.message = message;
	}



}
