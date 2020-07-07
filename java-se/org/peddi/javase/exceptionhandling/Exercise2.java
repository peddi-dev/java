package org.peddi.javase.exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Exercise2 {
	
	public  void cat(File file) {

	    String line = null;
	    try {
	    	RandomAccessFile input = new RandomAccessFile(file, "r");
		
		    try (input ) {
		        
		        while ((line = input.readLine()) != null) {
		            System.out.println(line);
		        }
		        return;
		    } catch (IOException e) {
				
				e.printStackTrace();
			} 
	    } catch (FileNotFoundException e1) {
			
			e1.printStackTrace();
			
		}

	}

	public static void main(String[] args) {
		Exercise2 app = new Exercise2();
	
		File file = new File("TestFile.txt");
		app.cat(file);

	}

}
