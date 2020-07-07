package org.peddi.javase.concurrency.guardedblock;

public class ProducerConsumerWithGuardedBlockDemo {
	
	
	public void producerConsumerDemo() {
		
		MessageContainer container = new MessageContainer();
		
		Thread p = new Thread(new Producer(container), "Thread-Producer");
		Thread c = new Thread(new Consumer(container), "Thread-Consumer");
		
		p.start();
		c.start();
		
	}
	
	public static void main(String[] a) {
		ProducerConsumerWithGuardedBlockDemo app = new ProducerConsumerWithGuardedBlockDemo();
		app.producerConsumerDemo();
	}
}
