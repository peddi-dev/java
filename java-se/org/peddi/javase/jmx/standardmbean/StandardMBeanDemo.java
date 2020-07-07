package org.peddi.javase.jmx.standardmbean;

import static java.lang.System.out;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;

import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;

public class StandardMBeanDemo {

	public void jmxAgentDemo() {

		out.println("===>jmxAgentDemo()");

		try {

			MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

			ObjectName name = new ObjectName("org.peddi.javase.jmx.standardmbean:type=SampleMBean");
			Sample mbeanObj = new Sample();
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
		StandardMBeanDemo app = new StandardMBeanDemo();
		app.jmxAgentDemo();

	}

}
