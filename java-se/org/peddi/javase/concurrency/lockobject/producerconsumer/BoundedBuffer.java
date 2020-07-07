package org.peddi.javase.concurrency.lockobject.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer<T> {
	
	private final Lock lock = new ReentrantLock();
	private final Condition notEmpty = lock.newCondition();
	private final Condition notFull = lock.newCondition();
	
	private Object[] buffer = new Object[100];
	private int count, putPtr, takePtr;
	
	public void put(T item) throws InterruptedException {
		
		lock.lock();
		try {
		
			if ( count == buffer.length) {
				notFull.await();
			}
			
			buffer[putPtr] = item;
			
			if( ++putPtr == buffer.length) {
				putPtr = 0;
			}
			
			count ++;
			
			notEmpty.signal();
			
		}finally {
			lock.unlock();
		}
			
		
	}
	
	public T take() throws InterruptedException {
		
		lock.lock();
		
		try {
			
			if ( count == 0 ) {
				notEmpty.await();
			}
			
			T item = (T) buffer[takePtr];
			 
			 if ( ++takePtr == buffer.length ) {
				 takePtr = 0;
			 }
			 count--;
			 
			 notFull.signal();
			 return item;
			
		}finally {
			lock.unlock();
		}
		
		
	}
	

}
