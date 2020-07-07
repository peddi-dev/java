package org.peddi.javase.concurrency.deadlock;

public class FriendsObjects {
	
	private final Friend alphones;
	private final Friend gorton;
	
	public FriendsObjects(Friend alphones, Friend gorton) {
		super();
		this.alphones = alphones;
		this.gorton = gorton;
	}

	public Friend getAlphones() {
		return alphones;
	}

	public Friend getGorton() {
		return gorton;
	}

}
