package org.peddi.javase.io.datastreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStreamsDemo {
	
	 final double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
	 final int[] units = { 12, 8, 13, 29, 50 };
	 final String[] descs = {
	    "Java T-shirt",
	    "Java Mug",
	    "Duke Juggling Dolls",
	    "Java Pin",
	    "Java Key Chain"
	};
	
	 String file = "datastreamdemo.dat";
	public void dataStreamOutput() {
		
		try(var douts = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(file)))){
			
			for(int i = 0; i < units.length; i++) {
				douts.writeDouble(prices[i]);
				douts.writeInt(units[i]);
				douts.writeUTF(descs[i]);
			}
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}finally {
			
		}
	}
	
	public void dataStreamInput() {
		try(var dins = new DataInputStream(new BufferedInputStream(new FileInputStream(file)))){
			
			for ( int i=0; i < units.length; i++) {
				double price = dins.readDouble();
				int units = dins.readInt();
				String desc = dins.readUTF();
				
				System.out.format("%nPrice: %10f, Units: %2d, Description: %s", price, units, desc );
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
		}
	}

	public static void main(String[] args) {
		
		DataStreamsDemo app = new DataStreamsDemo();
		app.dataStreamOutput();
		app.dataStreamInput();
		System.out.println("Data Streams demo complete");
	}

}
