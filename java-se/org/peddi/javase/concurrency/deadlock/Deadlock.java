package org.peddi.javase.concurrency.deadlock;

public class Deadlock {
	
	private final FriendsObjects friends;

	
	public Deadlock() {
		
		
		this.friends = new FriendsObjects(new Friend("Alphones"),
				 						  new Friend("Gorton")
				 						 );

	}
	
	public FriendsObjects getFriends() {
		return friends;
	}



	public void deadlock() {
		
		Thread at =  new Thread( new AlphonesThread(getFriends()));
				
//				new Thread(new Runnable() {
//			@Override	
//			public void run() {
//					
//					alphones.bow(gorton);
//					
//					System.out.println("End of " + Thread.currentThread().getName());
//				}
//			},
//		  "Thread-Alphones"
//		);
		
		Thread gt =  new Thread(new GortonThread(getFriends()));
				
//				new Thread(new Runnable() {
//			@Override	
//			public void run() {
//					
//					
//					gorton.bow(alphones);
//					
//					System.out.println("End of " + Thread.currentThread().getName());
//				}
//			},
//			"Thread-Gorton"
//		);
		
		at.start();
		gt.start();
		
		System.out.println("returning from Deadlock.deadlock()");
	}
	

}
