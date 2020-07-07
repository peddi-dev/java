package org.peddi.javase.networking.net.socket.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class KnockKnockClient {
	
public void client(String serverHost, int serverPort) {
		
		
		
		try(
			
			Socket socket = new Socket(serverHost, serverPort);
			var socketWrite = new PrintWriter(socket.getOutputStream(),true);
			var socketRead = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			var stdIn = new BufferedReader(new InputStreamReader(System.in));
		){
			String fromServer;
			while ((fromServer = socketRead.readLine()) != null) {
			    System.out.println("Server: " + fromServer);
			    if (fromServer.equals("Bye."))
			        break;

			    String fromUser = stdIn.readLine();
			    if (fromUser != null) {
			        System.out.println("Client: " + fromUser);
			        socketWrite.println(fromUser);
			    }
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		KnockKnockClient app = new KnockKnockClient();
		app.client("", 0);

	}

}
