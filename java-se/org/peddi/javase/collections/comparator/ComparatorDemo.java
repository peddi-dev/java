package org.peddi.javase.collections.comparator;

import static java.lang.System.out;

import java.util.Comparator;

public class ComparatorDemo {
	
	public void printDeck(StandardDeck deck) {
		
		out.println("\n\nCards In Deck \n");
		out.println(deck.deckToString());
	}
	
	public void sortDeck(StandardDeck deck) {
		deck.sort();
		out.println("\nStandardDeck::sort() ");
		printDeck(deck);
	}
	
	public void sortDeckByRank(StandardDeck deck) {
		
		deck.sort(Comparator.comparing(Card::getRank));
		out.println("\n sortDeckByRank::sort() ");
		printDeck(deck);
		
	}
	
    public void sortDeckByRankAndSuit(StandardDeck deck) {
		
		deck.sort(Comparator.comparing(Card::getRank)
				            .thenComparing(Comparator.comparing(Card::getSuit))
				);
		out.println("\nsortDeckByRankAndSuit::sort() ");
		printDeck(deck);
		
	}
    
    public void sortDeckByRankInReverseAndSuit(StandardDeck deck) {
		
		deck.sort(Comparator.comparing(Card::getRank)
				            .reversed()
				            .thenComparing(Comparator.comparing(Card::getSuit))
				);
		out.println("\nsortDeckByRankInReverseAndSuit) ");
		printDeck(deck);
		
	}
	
	
	
	public static void main(String[] args) {
		
		ComparatorDemo app = new ComparatorDemo();
		StandardDeck deck = new StandardDeck();
		
		app.printDeck(deck);
		//app.sortDeck(deck);
		//app.sortDeckByRank(deck);
		//app.sortDeckByRankAndSuit(deck);
		app.sortDeckByRankInReverseAndSuit(deck);
		
		
		
		
	}

}
