package org.peddi.javase.io.nio.file;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FilesDemo {

	private final String base = System.getenv("HOME") + "/AppData/JavaFileIO/";
	String pstr = "Path1/Test.txt";
	URI uri1 = URI.create("File:///" + base + "Path1/Hello.java");

	public void checking() {

		out.println("checking");
		Path p1 = Path.of(base, pstr);
		boolean fileExists = Files.exists(p1);
		out.printf("exists: %b%n", fileExists);

		String sp2 = base + "/../JavaFileIO/" + pstr;
		Path p2 = Path.of(sp2);
		try {
			out.printf("isSameFile: %b%n", Files.isSameFile(p1, p2));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void delete() {
		out.println("Delete");
		Path path = Path.of(base + pstr);

		try {
			// Files.delete(path);
			Files.deleteIfExists(path);
			out.printf("Path deleted: %s%n", path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void copy() {
		out.println("******copy");
		Path path1 = Path.of(base + pstr);
		Path path2 = Path.of(base + "Path1/Test2.txt");
		
		try {
			Files.copy(path1, path2);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try(var stream = new BufferedReader(new FileReader(path2.toFile()))){
			
			String line = null;
			while ( (line = stream.readLine()) != null) {
				out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void move() {
		out.println("******copy");
		Path path1 = Path.of(base + pstr);
		Path path2 = Path.of(base + "Path1/Test3.txt");
		
		try {
		
			Files.move(path1, path2, StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	try(var stream = new BufferedReader(new FileReader(path2.toFile()))){
			
			String line = null;
			while ( (line = stream.readLine()) != null) {
				out.println(line);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {

		FilesDemo app = new FilesDemo();
		// app.checking();
		// app.delete();
		// app.copy();
		app.move();

	}

}
