package org.peddi.javase.jmx.customclient;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationListener;
import static java.lang.System.out;

public class ClientListener implements NotificationListener {

	@Override
	public void handleNotification(Notification notification, Object handback) {
		
		out.println("Notification Received.");
		out.printf("%nClassName: %s", notification.getClass().getName());
		out.printf("%Source: %s", notification.getSource());
		out.printf("%Type: %s", notification.getType());
		out.printf("%Message: %s", notification.getMessage());
		
		if ( notification instanceof AttributeChangeNotification) {
			AttributeChangeNotification acn = (AttributeChangeNotification) notification;
			out.printf("%nAttributeName: %s", acn.getAttributeName());
			out.printf("%nAttributeType: %s", acn.getAttributeType());
			out.printf("%nOld Value: %s", acn.getOldValue());
			out.printf("%nNew Value: %s", acn.getNewValue());
		}

	}

}
