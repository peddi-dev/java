package org.peddi.javase.io.charstreams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedCharStreamDemo {
	
	public void bufferedCharStreamDemo(String file) {
		
		try(var input = new BufferedReader( new FileReader(file)); 
		    var output = new PrintWriter(new BufferedWriter(new FileWriter("bufferedcharout.txt"))) ){
			
			String line = null;
			while ((line = input.readLine()) != null ) {
				output.println(line);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
	
		String file =  "charinput.txt";
		BufferedCharStreamDemo app = new BufferedCharStreamDemo();
		app.bufferedCharStreamDemo(file);
		
		System.out.println("Buffered Char Stream Demo complete");

	}

}
