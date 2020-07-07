package org.peddi.javase.concurrency.deadlock;

public class GortonThread implements Runnable {
	
	private final FriendsObjects friends;
	
	
	public GortonThread(FriendsObjects fo){
		this.friends = fo;
	}

	@Override
	public void run() {
		
		getFriends().getGorton().bow(getFriends().getAlphones());
		

	}

	public FriendsObjects getFriends() {
		return friends;
	}

	

}
