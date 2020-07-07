package org.peddi.javase.concurrency.lockobject.producerconsumer.arrayblockingq;



import java.util.concurrent.ArrayBlockingQueue;

import org.peddi.javase.concurrency.lockobject.producerconsumer.BoundedBuffer;

public class ProducerConsumerDemoWithArrayBlockingQ {
	
	public void producerConsumerDemo() {
		
		System.out.println("Producer Consumer Solution with java.util.concurrent.ArrayBlockingQueue");
		ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(100);
		
		ProducerWithArrayBlockingQ pwabq = new ProducerWithArrayBlockingQ(buffer);
		ConsumerWithArrayBlockingQ cwabq = new ConsumerWithArrayBlockingQ(buffer);
		
		Thread producer = new Thread(pwabq, "Thread-Producer");
		Thread consumer = new Thread(cwabq, "Thread-Consumer");
				
		producer.start();
		consumer.start();
		
	}

	public static void main(String[] args) {
		
		ProducerConsumerDemoWithArrayBlockingQ app = new ProducerConsumerDemoWithArrayBlockingQ();
		app.producerConsumerDemo();
		
	}

}
