package org.peddi.javase.generics;


/**
 * K,V are type parameters
 * 
 * @author peddi
 *
 * @param <K>
 * @param <V>
 */

public class OrderedPair<K, V> implements Pair<K, V> {
	private K key;
	private V value;
	
	public OrderedPair(){
		
	}
	
	OrderedPair(K k, V v){
		this.key = k;
		this.value = v;
	}

	@Override
	public K getKey() {
		
		return this.key;
	}

	@Override
	public V getValue() {
		
		return this.value;
	}

}
