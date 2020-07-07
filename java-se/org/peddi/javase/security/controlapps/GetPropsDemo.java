package org.peddi.javase.security.controlapps;

import static java.lang.System.out;

public class GetPropsDemo {
	
	public void getPropsDemo() {
		out.printf("%nos.name=%s", System.getProperty("os.name", "not specified"));
		
		out.printf("%nuser.home=%s", System.getProperty("user.home", "not specified"));
		
		out.printf("%njava.version=%s", System.getProperty("java.version", "not specified"));
		
		out.printf("%njava.home=%s", System.getProperty("java.home", "not specified"));
		
	}

	public static void main(String[] args) {
		GetPropsDemo app = new GetPropsDemo();
		app.getPropsDemo();

	}

}
