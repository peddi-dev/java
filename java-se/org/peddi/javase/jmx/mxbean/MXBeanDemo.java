package org.peddi.javase.jmx.mxbean;

import static java.lang.System.out;

import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class MXBeanDemo {

	public void mxBeanDemo() {
		out.println("====>notificationDemo()");

		try {

			ObjectName name = new ObjectName("org.peddi.javase.jmx.mxbean:type=QueueSamplerMXBean");
			
			Queue<String> queue = new ArrayBlockingQueue<String>(10);
	        queue.add("Request-1");
	        queue.add("Request-2");
	        queue.add("Request-3");
			
	        QueueSampler beanObj = new QueueSampler(queue);
			
	        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
			
	        mbs.registerMBean(beanObj, name);

			out.println("Waiting for MBean Server....");
			Thread.sleep(Long.MAX_VALUE);

		} catch (MalformedObjectNameException e) {

			e.printStackTrace();
		} catch (InstanceAlreadyExistsException e) {

			e.printStackTrace();
		} catch (MBeanRegistrationException e) {

			e.printStackTrace();
		} catch (NotCompliantMBeanException e) {

			e.printStackTrace();
		} catch (InterruptedException e) {

			e.printStackTrace();
		} 

	}

	public static void main(String[] args) {

		MXBeanDemo app = new MXBeanDemo();
		app.mxBeanDemo();
	}

}
