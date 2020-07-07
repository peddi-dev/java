package org.peddi.javase.io.bytestreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteStreamDemo {

	public void byteStreamDemo(String file) {

		try (var fis = new FileInputStream(file); var fos = new FileOutputStream("bytestream2.dat")) {
			int b = 0;
			while ((b = fis.read()) != -1) {
				fos.write(b);
			}
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		ByteStreamDemo app = new ByteStreamDemo();
		String file = "bytestream.dat";
		app.byteStreamDemo(file);
		
		System.out.println("Byte Stream Demo complete");

	}

}
