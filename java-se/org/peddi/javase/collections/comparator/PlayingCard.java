package org.peddi.javase.collections.comparator;

public class PlayingCard implements Card {
	private  Card.Suit suit;
	private  Card.Rank rank;
	

	public PlayingCard(Suit suit, Rank rank) {
		super();
		this.rank = rank;
		this.suit = suit;
	}
	
	@Override
	public String toString() {
		return "PlayingCard [suit=" + suit + ", rank=" + rank + "]";
	}
	
	@Override
	public int compareTo(Card c) {
		return  (int) Math.signum(  this.hashCode() - c.hashCode() ) ; 
	}

	@Override
	public Suit getSuit() {
		return suit;
	}

	@Override
	public Rank getRank() {
		return rank;
	}

	@Override
	public int hashCode() {
		return ((getSuit().value() - 1) * 13) + getRank().value();
	}

}
