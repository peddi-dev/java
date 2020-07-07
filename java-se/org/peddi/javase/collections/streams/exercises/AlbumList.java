package org.peddi.javase.collections.streams.exercises;

import java.util.ArrayList;
import java.util.List;

class AlbumList {
	
	List<Album> albums = new ArrayList<>(); 
	
	public AlbumList() {
		
		List<Track> tracks;
		Album album ;
		Track t;

		
		tracks = new ArrayList<Track>();
		t = new Track("TS21", 2);
		tracks.add(t);
		t = new Track("TS25", 5);
		tracks.add(t);
		t = new Track("TS23", 4);
		tracks.add(t);
		album = new Album("A2", tracks);
		albums.add(album);
		
		
		tracks = new ArrayList<Track>();
		t = new Track("TS1", 1);
		tracks.add(t);
		t = new Track("TS5", 5);
		tracks.add(t);
		t = new Track("TS3", 3);
		tracks.add(t);
		album = new Album("A1", tracks);
		albums.add(album);
		
		tracks = new ArrayList<Track>();
		t = new Track("TS31", 3);
		tracks.add(t);
		t = new Track("TS35", 2);
		tracks.add(t);
		t = new Track("TS33", 2);
		tracks.add(t);
		album = new Album("A3", tracks);
		albums.add(album);
		

	}

	public List<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}
}
