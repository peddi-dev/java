package org.peddi.javase.networking.net.cookies;

import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.InetAddress;
import java.net.URI;
import java.net.UnknownHostException;

/**
 * Cookie Policy rejects cookies from domains on blacklist
 * @author peddi
 *
 */
public class CustomCookiePolicy implements CookiePolicy {
	
	String[] blacklistDomains;
	
	CustomCookiePolicy(String[] blacklistDomains){
		this.blacklistDomains = blacklistDomains;
	}

	@Override
	public boolean shouldAccept(URI uri, HttpCookie cookie) {
		String host;
		
		try {
			host = InetAddress.getByName(uri.getHost()).getCanonicalHostName();
			for(String domain: this.blacklistDomains) {
				if(HttpCookie.domainMatches(domain, host)){
					return false;
				}
			}
		} catch (UnknownHostException e) {
			host = uri.getHost();
			e.printStackTrace();
		}
		
		return CookiePolicy.ACCEPT_ORIGINAL_SERVER.shouldAccept(uri, cookie);
	}

}
