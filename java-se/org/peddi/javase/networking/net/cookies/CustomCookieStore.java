package org.peddi.javase.networking.net.cookies;

import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

public class CustomCookieStore  implements CookieStore, Runnable {
	CookieStore store;
	
	public CustomCookieStore() {
		
		// get default in-memory cookie store
		CookieManager cm = new CookieManager();
		store = cm.getCookieStore();
		
		//TODO read cookies from persistent storage and add them to in-memory store
		
		// add shutdown hook to save in-memory store to the  persistent storage
		Runtime.getRuntime().addShutdownHook(new Thread(this));
	}
	
	@Override
	public void run() {
		// TODO save cooking in the local in-memory to persistent storage
		
	}

	@Override
	public void add(URI uri, HttpCookie cookie) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<HttpCookie> get(URI uri) {
		return store.get(uri);
	}

	@Override
	public List<HttpCookie> getCookies() {
		
		return store.getCookies();
	}

	@Override
	public List<URI> getURIs() {
		
		return store.getURIs();
	}

	@Override
	public boolean remove(URI uri, HttpCookie cookie) {
		
		return store.remove(uri, cookie);
	}

	@Override
	public boolean removeAll() {
		
		return store.removeAll();
	}

}
