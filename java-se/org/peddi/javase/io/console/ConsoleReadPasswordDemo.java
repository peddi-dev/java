package org.peddi.javase.io.console;

import java.io.Console;
import java.util.Arrays;

public class ConsoleReadPasswordDemo {
	
	public void consoleReadPasswordDemo () {
		
		Console console = System.console();
		
		if ( console == null) {
			System.err.println("No Console.");
			System.exit(1);
		}
		
		char[] currPasswd = null;
		char[] newPasswd1 = null;
		char[] newPasswd2 = null;
		try {
			String login = console.readLine("Enter your login:");
			 currPasswd = console.readPassword("Enter Current Password:");
			 newPasswd1 = console.readPassword("Enter new password");
			 newPasswd2 = console.readPassword("Re-Enter new password");
			
			if (Arrays.equals(newPasswd1,  newPasswd2)) {
				changePassword(currPasswd, newPasswd1);
				console.format("Password changed. %n");
			}else {
				console.format("Passwords do not match. Try again %n");
			}
		}finally{
			// clear the sensitive data to reduce the life time
			Arrays.fill(currPasswd, ' ');
			Arrays.fill(newPasswd1, ' ');
			Arrays.fill(newPasswd2, ' ');
		}
		
		
		
	}
		
	
	public void changePassword(char[] currPasswd, char[] newPasswd) {
		
	}

	public static void main(String[] args) {
		
		ConsoleReadPasswordDemo app = new ConsoleReadPasswordDemo();
		app.consoleReadPasswordDemo();
		
		//Note: Run This program from command line

	}

}
