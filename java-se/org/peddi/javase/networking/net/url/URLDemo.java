package org.peddi.javase.networking.net.url;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
public class URLDemo {
	
	public void createAbsoluteURL() {
		out.println("****createAbsoluteURL()");
		try {
			URL url = new URL("http://java.net");
			URL url2 = new URL("http", "java.net", "/pages/modules.html");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	public void createRelativeURL() {
		
		out.println("****createRelativeURL()");
		try {
			URL base = new URL("http://example.com/pages");
			URL url1 = new URL(base, "Page1.html");
			URL url2 = new URL(base, "Page2.html");
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void getURLComponents() {
		
		out.println("****getURLComponents()");
		String urlStr = "http://example.com:80/docs/books/tutorial"
                + "/index.html?name=networking#DOWNLOADING";
		try {
			URL url = new URL(urlStr);
			
			out.printf("Protocol: %s%n", url.getProtocol());
			out.printf("Authority: %s%n", url.getAuthority());
			out.printf("Host: %s%n", url.getHost());
			out.printf("Port: %s%n", url.getPort());
			out.printf("Path: %s%n", url.getPath());
			out.printf("Query: %s%n", url.getQuery());
			out.printf("File: %s%n", url.getFile());
			out.printf("Ref: %s%n", url.getRef());
			
			out.printf("UserInfo: %s%n", url.getUserInfo());
			out.printf("toString/toExternalForm: %s%n", url.toString());
			
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void readDirectlyFromURL() {
		out.println("****readDirectlyFromURL()");
		try {
			URL url = new URL("http://java.net");
			try(var stream = new BufferedReader(new InputStreamReader(url.openStream()))){
				
				stream.transferTo(new PrintWriter(out));
				
//				String line;
//				while( (line = stream.readLine()) != null) {
//					out.println(line);
//				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void connectToURL() {
		out.println("****connectToURL()");
		try {
			URL url = new URL("http://java.net");
			URLConnection urlConnection = url.openConnection();
			urlConnection.connect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void readWriteWithURLConnection() {
		out.println("****readWriteWithURLConnection()");
		try {
			URL url = new URL("http://java.net");
			URLConnection urlConn = url.openConnection();
			
			urlConn.setDoOutput(true);
			
			String param = "param=value";
			String input = URLEncoder.encode(param,"UTF-8");
			
			try(var outStream = new BufferedWriter(new OutputStreamWriter(urlConn.getOutputStream()))){
				
				outStream.write(input);
				
			}
			
			try(var inStream = new BufferedReader(new InputStreamReader(urlConn.getInputStream()))){
				String line;
				
				while ( (line = inStream.readLine()) != null){
					out.println(line);
				}
			}
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		URLDemo url = new URLDemo();
		//url.createAbsoluteURL();
		//url.createRelativeURL();
		//url.getURLComponents();
		//url.readDirectlyFromURL();
		//url.connectToURL();
		url.readWriteWithURLConnection();
	}

}
