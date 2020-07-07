package org.peddi.javase.networking.net.socket.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class KnockKnockServer {
	public void server(int serverProgramPort) {
		
		
		try(
				ServerSocket srvrSocket = new ServerSocket(serverProgramPort);
				Socket clientSocket = srvrSocket.accept();
				var socketRead = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
				var socketWrite = new PrintWriter(clientSocket.getOutputStream(), true);
			
			){
			
			// Initiate conversation with client
		    KnockKnockProtocol kkp = new KnockKnockProtocol();
		    String outputLine = kkp.processInput(null);
		    socketWrite.println(outputLine);
			
			String inLine;
			while((inLine = socketRead.readLine()) != null) {
				outputLine = kkp.processInput(inLine);	 
				socketWrite.println(outputLine);
				if (outputLine.equals("Bye."))
		            break;
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch blockI
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		KnockKnockServer app = new KnockKnockServer();
		app.server( 0);

	}
}
