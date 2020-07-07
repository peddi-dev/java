package org.peddi.javase.networking.net.datagram.multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.net.UnknownHostException;

import org.peddi.javase.networking.net.datagram.QuoteClient;

public class MulticastClient {
	public void client(String host) {

		try (var mcastSocket = new MulticastSocket(4446);) {

			InetAddress group = InetAddress.getByName("230.0.0.1");
			mcastSocket.joinGroup(group);

			// get response
			DatagramPacket serverPacket;
			for (int i = 0; i < 5; i++) {
				byte[] buffer = new byte[256];
				serverPacket = new DatagramPacket(buffer, buffer.length);
				mcastSocket.receive(serverPacket);

				// display data
				String quote = new String(serverPacket.getData(), 0, serverPacket.getLength());

				System.out.printf("Quote of the Moment : %s%n", quote);
			}

			mcastSocket.leaveGroup(group);

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
