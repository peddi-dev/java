package org.peddi.javase.networking.net.datagram.multicast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.time.ZonedDateTime;

public class MulticastServerThread implements Runnable {
	protected String quotesFile;
	protected BufferedReader quoteReader = null;
	protected boolean moreQuotes = true;

	@Override
	public void run() {
		// port 4445 is arbitrary
		try( var datagramSocket = new DatagramSocket(4445)){
			
			while(moreQuotes) {
				
				try{
					
//					//receive client request
//					byte[] buf = new byte[256];
//					DatagramPacket requestPacket = new DatagramPacket(buf, buf.length);
//					datagramSocket.receive(requestPacket);
//					
					//send response
					InetAddress address = InetAddress.getByName("230.0.0.1");
					int port = 4446;
					String tq = getNextQuote();
					byte[] quote = tq == null ? (ZonedDateTime.now().toString().getBytes()) :getNextQuote().getBytes();
					DatagramPacket responsePacket = new DatagramPacket(quote, 
										quote.length,
										address,
										port);
					
					datagramSocket.send(responsePacket);
					
					try {
		                Thread.sleep((long)Math.random() * 5000);
		            } 
		            catch (InterruptedException e) { }
					
				} catch (SocketException e) {
					moreQuotes = false;
					e.printStackTrace();
				} catch (IOException e) {
					moreQuotes = false;
					e.printStackTrace();
				}
			}
		} catch (SocketException e1) {
			e1.printStackTrace();
		}

	}
	
	protected String getNextQuote() {
		
		String quote = null;
		try {
			if (quoteReader == null) {
				quoteReader = new BufferedReader(new FileReader(quotesFile));
			}
			
			quote = quoteReader.readLine();
			if (quote == null) {
				quote = "No more Quotes. Good Bye.";
				clear();
			}
			
		} catch (FileNotFoundException e) {
			clear();
			e.printStackTrace();
		} catch (IOException e) {
			
			clear();
			e.printStackTrace();
		}finally {
			
		}
		
		return quote;
	}
	
	protected void clear() {
		moreQuotes=false;
		if (quoteReader != null)
			try {
				quoteReader.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	}

}
