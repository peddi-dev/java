module javase {
	
	
	exports org.peddi.javase.jmx.standardmbean;
	exports org.peddi.javase.jmx.mxbean;
	exports org.peddi.javase.jmx.standardmbean.notification;
	exports org.peddi.javase.jmx.customclient;
	
	requires java.management;
	requires java.desktop;
	requires java.rmi;
	requires java.sql;
	requires java.xml;
}