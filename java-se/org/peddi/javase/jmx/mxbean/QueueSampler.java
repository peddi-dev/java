package org.peddi.javase.jmx.mxbean;

import java.time.LocalDate;
import java.util.Queue;

public class QueueSampler implements QueueSamplerMXBean {
	
	private Queue<String> queue;
	
	public QueueSampler(Queue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void clearQueue() {
		
		synchronized(queue) {
			queue.clear();
		}
	}

	@Override
	public QueueSample getQueueSample() {
		
		synchronized(queue) {
		
			return new QueueSample(LocalDate.now(),
				queue.size(),
				queue.peek());
		}
	}

}
