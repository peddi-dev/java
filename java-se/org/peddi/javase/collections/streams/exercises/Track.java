package org.peddi.javase.collections.streams.exercises;

class Track {
	
	private String track;
	private int rating;
	
	public Track(String track, int rating) {
		super();
		this.track = track;
		this.rating = rating;
	}
	
	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Track [track=" + track + ", rating=" + rating + "]";
	}	
	
}