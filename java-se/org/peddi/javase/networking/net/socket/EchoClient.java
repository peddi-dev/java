package org.peddi.javase.networking.net.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	
	public void client(String serverHost, int serverPort) {
		
		
		
		try(
			
			Socket socket = new Socket(serverHost, serverPort);
			var socketWrite = new PrintWriter(socket.getOutputStream(),true);
			var socketRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			var stdIn = new BufferedReader(new InputStreamReader(System.in));
		){
			String data;
			while((data = stdIn.readLine()) != null) {
				
				// send data to server through socket
				socketWrite.println(data);
				
				// get data from the server through socket
				String serverData = socketRead.readLine();
				
				System.out.println(serverData);
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
