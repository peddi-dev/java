package org.peddi.javase.jmx.standardmbean.notification;

public interface SampleNotificationMBean {
	//operations
	void sayHello();
	int add(int x, int y);
	
	//attributes
	String getName();
	int getCacheSize();
	void setCacheSize(int cacheSize);

}
