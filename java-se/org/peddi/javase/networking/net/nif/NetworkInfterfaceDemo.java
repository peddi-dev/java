package org.peddi.javase.networking.net.nif;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.InterfaceAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.net.Socket;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.stream.Stream;

import static  java.lang.System.out;

public class NetworkInfterfaceDemo {
	
	public void networkInterfaceObjectWithSockets(String serverHost,
													int serverPort) {
		try {
			// 1. Implicit NIC.
			// System determines which local NIC to be used.
			InetSocketAddress serverSocAddress = new InetSocketAddress(serverHost,serverPort );
			Socket soc = new Socket();
			soc.connect(serverSocAddress);
			
			//2. Specifying  NIC Explicitly
			NetworkInterface nif = NetworkInterface.getByName("bge0");
			Enumeration<InetAddress> nifAddresses = nif.getInetAddresses();
			InetAddress localAddress = nifAddresses.nextElement();
			int localPort = 0;
			InetSocketAddress  localInetSocAddresss = new InetSocketAddress(localAddress, localPort );
			
			Socket soc2 = new Socket();
			
			//bind to local address
			soc2.bind(localInetSocAddresss);
			
			// connect to server address
			InetSocketAddress serverInetSocketAddress = new InetSocketAddress(serverHost, serverPort);
			soc2.connect(serverInetSocketAddress);
			
			//3. Multicast Group
			MulticastSocket mcastSoc = new MulticastSocket();
			mcastSoc.joinGroup(serverInetSocketAddress, nif);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

	public void retrieveNetworkInterfaces() {
		
		out.println("****retrieveNetworkInterfaces");
		
		try {
			Stream<NetworkInterface> nifs = NetworkInterface.networkInterfaces();
			
			nifs.forEach(this::fetchNIF);
			
		} catch (SocketException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private void fetchNIF(NetworkInterface nif) {
		 printNIF(nif);
		 Stream<NetworkInterface> subNifs = nif.subInterfaces();
		 if(subNifs.count() > 0) {
			 out.println("\n SubInterfaces");
			 subNifs.forEach(this::printNIF);
		 }
	}
	
	private void printNIF(NetworkInterface nif) {

		out.printf("%nName: %s%n", nif.getName());
		out.printf("DisplayName: %s%n", nif.getDisplayName());
	}
	
	public void retrieveInterfaceAddresses() {
		out.println("****retrieveNetworkInterfaces");
		try {
			
			Stream<NetworkInterface> nifs = NetworkInterface.networkInterfaces();
			nifs.forEach(this::iterateInterfaceAddresses);
			
		} catch (SocketException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private void iterateInterfaceAddresses(NetworkInterface nif) {
		
		nif.getInterfaceAddresses().stream().forEach(this::printInterfaceAddress);
	}
	private void printInterfaceAddress(InterfaceAddress ia) {
		out.printf("%nAddress: %s%n", ia.getAddress());
		out.printf("Broadcast Address: %s%n", ia.getBroadcast());
		out.printf("Network Prefix Length: %s%n", ia.getNetworkPrefixLength());
	}
	
	
	public void retrieveNetworkInterfaceParameters() {
		out.println("****retrieveNetworkInterfaces");
		try {
			NetworkInterface.networkInterfaces().forEach(this::printNIFParams);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void printNIFParams(NetworkInterface nif) {
		try {
		out.printf("%nDisplay Name: %s%n", nif.getDisplayName());
		
		out.printf("HardwareAddress: %s%n", nif.getHardwareAddress());
		out.printf("MTU: %s%n", nif.getMTU());

		out.printf("isUP: %b%n", nif.isUp());
		out.printf("isLoopback: %s%n", nif.isLoopback());
		out.printf("isPointToPoint: %s%n", nif.isPointToPoint());
		out.printf("isVirtual: %s%n", nif.isVirtual());
		out.printf("supportsMulticast: %s%n", nif.supportsMulticast());
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public static void main(String[] args) {
		NetworkInfterfaceDemo app = new NetworkInfterfaceDemo();
		String serverHost = "http://java.net";
		int serverPort = 3455;
		//app.networkInterfaceObjectWithSockets(serverHost, serverPort);
		//app.retrieveNetworkInterfaces();
		//app.retrieveInterfaceAddresses();
		app.retrieveNetworkInterfaceParameters();

	}

}
