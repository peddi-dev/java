package org.peddi.javase.collections.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import org.peddi.javase.collections.comparator.Card.Rank;
import org.peddi.javase.collections.comparator.Card.Suit;

import static java.lang.System.out;

public class StandardDeck implements Deck {
	
	private List<Card> cards;
	
	private void createCards(boolean reset) {
		
		if( cards != null && !reset ) {
			return;
		}
		
		cards = new ArrayList<Card>(52);
		
		
		for(int i=3; i>=0; i--) {
			
			
			
			Suit s = Suit.values()[i];
			
			for (int j=12; j>=0; j--) {
				
				
			
				Rank r = Rank.values()[j];
				
				cards.add(new PlayingCard(s, r));
			}
		}
		
		
		
	}

	@Override
	public String toString() {
		return "StandardDeck [cards=" + cards + "]";
	}

	@Override
	public List<Card> getCards() {
		
		if ( cards == null) {
			createCards(false);
		}
		
		return cards;
	}


	@Override
	public int size() {
		
		return cards.size();
	}

	@Override
	public void addCard(Card card) {
		
		getCards().add(card);

	}

	@Override
	public void addCards(List<Card> cards) {
		
		getCards().addAll(cards);

	}
	
	@Override
	public void shuffle() {
		
		//createCards(true);
		Collections.shuffle(getCards());

	}

	@Override
	public void sort() {
		Collections.sort(getCards());

	}

	@Override
	public void sort(Comparator<Card> c) {
		Collections.sort(getCards(), c);
	}

	@Override
	public String deckToString() {
		
		return getCards().toString();
	}

	@Override
	public Map<Integer, Deck> deal(int players, int numberOfCards) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Deck deckFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDeck(Deck deck) {
		// TODO Auto-generated method stub

	}
	
	public static void main(String[] args) {
		
		StandardDeck d = new StandardDeck();
		out.println(d.getCards());
		
		d.shuffle();
		out.println(d.getCards());
//		Rank[] rs = Card.Rank.values();
//		Arrays.stream(rs).forEach(e -> out.print(" "+ e));
//		Arrays.sort(rs);
//		out.println();
//		Arrays.stream(rs).forEach(e -> out.print(" "+ e));
		
	}

}
