package org.peddi.javase.jmx.standardmbean.notification;

import static java.lang.System.out;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;




public class NotificationDemo {

	public void notificationDemo() {

		out.println("===>notificationDemo()");

		try {
			
				MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
	
				ObjectName name = new ObjectName("org.peddi.javase.jmx.standardmbean.notification:type=SampleNotificationMBean");
				SampleNotification mbeanObj = new SampleNotification();
				mbs.registerMBean(mbeanObj, name);
	
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
		NotificationDemo app = new NotificationDemo();
		app.notificationDemo();

	}

}
