package org.peddi.javase.collections.streams.exercises;

import java.util.Comparator;

public class AlbumComparator implements Comparator<Album>{
	
	public AlbumComparator(Album a1, Album a2) {
		
	}
	public AlbumComparator() {}

	@Override
	public int compare(Album a1, Album a2) {
		return a1.getName().compareTo(a2.getName());
	}

}
