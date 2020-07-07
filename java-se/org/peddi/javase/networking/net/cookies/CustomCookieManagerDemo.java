package org.peddi.javase.networking.net.cookies;

import java.net.CookieHandler;
import java.net.CookieManager;

public class CustomCookieManagerDemo {
	
	public void customCookieManagerDemo(String[] blacklistDomains) {
		
		CookieManager cm = new CookieManager();
		CustomCookiePolicy customCP = new CustomCookiePolicy(blacklistDomains);
		cm.setCookiePolicy(customCP);
		CookieHandler.setDefault(cm);
	}
	
	public static void main(String...args) {
		CustomCookieManagerDemo app = new CustomCookieManagerDemo();
		String[] blacklistDomains = new String[] {"example.com"};
		app.customCookieManagerDemo(blacklistDomains);
		
		/**
		 *  sample Rejected domains 
			host.example.com
			domain.example.com
			
			Sample Accepted Domains
			example.com
			example.org
			myhost.example.org
		 */
	}

}
