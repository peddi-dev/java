package org.peddi.javase.jmx.standardmbean.notification;

import static java.lang.System.out;

import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;


public class SampleNotification extends NotificationBroadcasterSupport 
	implements SampleNotificationMBean {
	
	private final int CACHE_SIZE = 200;
	private int cacheSize = CACHE_SIZE;
	private final String name="PeddiMBean";
	private long sequenceNumber = 1;
	
	@Override
	public MBeanNotificationInfo[] getNotificationInfo() {
		
		String[] notificationTypes = new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE };
		String name = AttributeChangeNotification.class.getName();
		String description = "An attribute of this MBean has changed";
		MBeanNotificationInfo info = new MBeanNotificationInfo(notificationTypes, 
																name, 
																description);
		
		return new MBeanNotificationInfo[] {info};
	}
	
	@Override
	public synchronized void setCacheSize(int cacheSize) {
		int oldCacheSize = this.cacheSize;
		this.cacheSize = cacheSize;
		out.printf("=====>Cache Size is now set to : %d%n", this.cacheSize);
		
		Notification notification = new AttributeChangeNotification(this, 
				sequenceNumber++,
				System.currentTimeMillis(),
				"CacheSize changed",
				"CacheSize",
				"int",
				oldCacheSize,
				this.cacheSize
				);
		
		sendNotification(notification);

	}	

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



}
