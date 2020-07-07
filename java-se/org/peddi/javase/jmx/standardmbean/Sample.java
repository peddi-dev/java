package org.peddi.javase.jmx.standardmbean;

import  static java.lang.System.out;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class Sample   implements SampleMBean {
	
	private final int CACHE_SIZE = 200;
	private int cacheSize = CACHE_SIZE;
	private final String name="PeddiMBean";
	
	
	@Override
	public void sayHello() {
		out.println("====>Hello MBean Operation");
	}

	@Override
	public int add(int x, int y) {
		
		return  x + y;
	}

	@Override
	public String getName() {
		
		return name;
	}

	@Override
	public int getCacheSize() {
		
		return cacheSize;
	}

	@Override
	public synchronized void setCacheSize(int cacheSize) {
		this.cacheSize = cacheSize;
		out.printf("=====>Cache Size is now set to : %d%n", this.cacheSize);

	}
	
	

}
