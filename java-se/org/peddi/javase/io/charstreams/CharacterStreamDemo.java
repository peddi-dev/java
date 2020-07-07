package org.peddi.javase.io.charstreams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamDemo {

	public void characterStreamDemo(String file) {
		
		try(var reader = new FileReader(file); var writer = new FileWriter("chatoutput.txt")){
			
			int c = 0;
			while( (c = reader.read()) != -1) {
				writer.write(c);
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		
		CharacterStreamDemo app = new CharacterStreamDemo();
		String file = "charinput.txt";
		app.characterStreamDemo(file);
		System.out.println("CharacterStreamDemo complete");
	}

}
