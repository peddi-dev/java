package org.peddi.javase.networking.net.datagram.multicast;

import org.peddi.javase.networking.net.datagram.QuoteServer;
import org.peddi.javase.networking.net.datagram.QuoteServerThread;

public class MulticastServer {
	
	public void server() {
		
		MulticastServerThread task = new MulticastServerThread();
		Thread qst = new Thread(task, "Multicast Quote Server");
		qst.start();
		
	}

	public static void main(String[] args) {
		QuoteServer app = new QuoteServer();
		app.server();

	}

}
