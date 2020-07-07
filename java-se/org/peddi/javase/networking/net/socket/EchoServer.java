package org.peddi.javase.networking.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	
	public void server(int serverProgramPort) {
		
	
		try(
				ServerSocket srvrSocket = new ServerSocket(serverProgramPort);
				Socket clientSocket = srvrSocket.accept();
				var socketRead = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				var socketWrite = new PrintWriter(clientSocket.getOutputStream(), true);
			
			){
			
			String data;
			while((data = socketRead.readLine()) != null) {
					 
				socketWrite.println(data);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch blockI
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		EchoServer app = new EchoServer();
		

	}

}
