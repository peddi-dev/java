package org.peddi.javase.concurrency.lockobject.producerconsumer;

public class ProducerConsumerDemo {
	
	public void producerConsumerWithBoundeBuffer() {
		
		BoundedBuffer buffer = new BoundedBuffer();
		
		Producer p = new Producer(buffer);
		Consumer c = new Consumer(buffer);
		
		Thread producer = new Thread(p, "Thread-Producer");
		Thread consumer = new Thread(c, "Thread-Consumer");
				
		producer.start();
		consumer.start();
		
	}

	public static void main(String[] args) {
		
		ProducerConsumerDemo app = new ProducerConsumerDemo();
		app.producerConsumerWithBoundeBuffer();

	}

}
