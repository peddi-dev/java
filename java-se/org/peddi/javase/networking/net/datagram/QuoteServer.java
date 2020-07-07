package org.peddi.javase.networking.net.datagram;

public class QuoteServer {
	
	public void server() {
		
		QuoteServerThread task = new QuoteServerThread();
		Thread qst = new Thread(task, "QuoteServer");
		qst.start();
		
	}

	public static void main(String[] args) {
		QuoteServer app = new QuoteServer();
		app.server();

	}

}
