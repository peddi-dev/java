package org.peddi.javase.jmx.customclient;

import static java.lang.System.out;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

import javax.management.InstanceNotFoundException;
import javax.management.JMX;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.peddi.javase.jmx.mxbean.QueueSample;
import org.peddi.javase.jmx.mxbean.QueueSamplerMXBean;
import org.peddi.javase.jmx.standardmbean.SampleMBean;

public class JMXCustomClient {
	
	public void jmxCustomClientDemo() {
		out.println("Create an RMI Connector Client and connect it to RMI Connector Server");
		try {
			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://:9999/jmxrmi");
			JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
			MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
			
			out.println("Domains:");
			String domains[] = mbsc.getDomains();
			Arrays.sort(domains);
			for(String d: domains) {
				out.printf("%nDomain: %s", d);
				
			}
			
			out.printf("%n%nMBean Server default domain: %s",mbsc.getDefaultDomain());
			out.printf("%n%nMBean Count: %s",mbsc.getMBeanCount());
			
			out.println("\n\nQuery MBean Server");
			Set<ObjectName> names = new TreeSet<ObjectName>(mbsc.queryNames(null,null));
			for(ObjectName on: names) {
				out.printf("%nObjectName:%s", on);
			}
			
			/**
			 * Performing Operations on Remote MBeans via Proxies
			 */
			ObjectName mbeanName = new ObjectName("org.peddi.javase.jmx.standardmbean.notification:type=SampleNotificationMBean");
			SampleMBean sampleMBeanProxy = JMX.newMBeanProxy(mbsc, mbeanName, SampleMBean.class,true);
			
			out.println("Add Notification Listener");
			ClientListener listener = new ClientListener();
			mbsc.addNotificationListener(mbeanName, listener, null, null);
			
			out.printf("%nCacheSize: %s", sampleMBeanProxy.getCacheSize());
			
			sampleMBeanProxy.setCacheSize(888);
			
			out.println("\nWaiting for Notification...");
			Thread.sleep(2000);
			out.printf("%nCacheSize: %s", sampleMBeanProxy.getCacheSize());
			
			out.println("\nInvoking sayHello() in SampleMBean");
			sampleMBeanProxy.sayHello();
			
			out.println("Invoking add() in SampleMBean");
			out.printf("%nadd(20,30): %s%n", sampleMBeanProxy.add(20, 30));
			
			/**
			 * Performing Operations on Remote MXBeans via Proxies
			 */
			ObjectName mxbeanName = new ObjectName("org.peddi.javase.jmx.mxbean:type=QueueSamplerMXBean");
			QueueSamplerMXBean queueSamplerMXBeanProxy = JMX.newMBeanProxy(mbsc, mxbeanName, QueueSamplerMXBean.class);
			
			QueueSample queue = queueSamplerMXBeanProxy.getQueueSample();
			out.printf("%n%nQueue.Date: %s", queue.getDate());
			out.printf("%n%nQueue.Head: %s", queue.getHead());
			out.printf("%n%nQueue.Size: %s", queue.getSize());
			
			out.println("Clearing the Queue");
			queueSamplerMXBeanProxy.clearQueue();
			
			out.printf("%n%nQueue.Date: %s", queue.getDate());
			out.printf("%n%nQueue.Head: %s", queue.getHead());
			out.printf("%n%nQueue.Size: %s", queue.getSize());
			
			jmxc.close();
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedObjectNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (InstanceNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		JMXCustomClient app = new JMXCustomClient();
		app.jmxCustomClientDemo();
	}

}
