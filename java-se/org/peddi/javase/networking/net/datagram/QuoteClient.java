package org.peddi.javase.networking.net.datagram;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class QuoteClient {

	public void client(String host) {

		try (var datagramSocket = new DatagramSocket();) {

			byte[] buffer = new byte[256];
			InetAddress address = InetAddress.getByName(host);
			// port 4445 is arbitrary
			DatagramPacket clientPacket = new DatagramPacket(buffer, buffer.length, address, 4445);
			// send request
			datagramSocket.send(clientPacket);

			// get response
			DatagramPacket serverPacket = new DatagramPacket(buffer, buffer.length);
			datagramSocket.receive(serverPacket);

			// display data
			String quote = new String(serverPacket.getData(), 0, serverPacket.getLength());

			System.out.printf("Quote of the Moment : %s%n", quote);

		} catch (SocketException e) {

			e.printStackTrace();
		} catch (UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		QuoteClient app = new QuoteClient();
		String host = null;
		app.client(host);
	}

}
