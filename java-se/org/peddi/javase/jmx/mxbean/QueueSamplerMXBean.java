package org.peddi.javase.jmx.mxbean;

import javax.management.MXBean;

@MXBean
public interface QueueSamplerMXBean {
	
		QueueSample getQueueSample();
		void clearQueue();
	
}


