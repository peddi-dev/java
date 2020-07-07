package org.peddi.javase.collections.streams.exercises;

import java.util.List;



class Album {
	
	private String name;
	private List<Track> tracks;

	public Album(String name, List<Track> tracks) {
		super();
		this.name = name;
		this.tracks = tracks;
	}

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	public boolean anyMatch() {
		return tracks.stream().anyMatch(t -> t.getRating() >= 4);
		
	}
	

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Album [name=" + name + ", tracks=" + tracks + "]";
	}
}
