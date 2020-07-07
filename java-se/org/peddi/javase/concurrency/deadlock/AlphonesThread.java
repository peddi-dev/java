package org.peddi.javase.concurrency.deadlock;

public class AlphonesThread implements Runnable {
	
	private final FriendsObjects friends;
	
	@Override
	public void run() {
		
		getFriends().getAlphones().bow(getFriends().getGorton());
		
	}

	public FriendsObjects getFriends() {
		return friends;
	}

	public AlphonesThread(FriendsObjects friends) {
		super();
		this.friends = friends;
	}

}
